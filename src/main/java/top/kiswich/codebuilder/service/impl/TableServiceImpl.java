package top.kiswich.codebuilder.service.impl;

import com.fasterxml.jackson.databind.exc.IgnoredPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.exception.NoTypeMatchException;
import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.*;
import top.kiswich.codebuilder.pojo.base.beforeparse.ColumnInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.pojo.base.beforeparse.TableInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMapping;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMappingContainer;
import top.kiswich.codebuilder.pojo.base.webFormat.in.*;
import top.kiswich.codebuilder.pojo.common.SqlConstant;
import top.kiswich.codebuilder.pojo.common.TableConstant;
import top.kiswich.codebuilder.service.IMysqlService;
import top.kiswich.codebuilder.service.IParseService;
import top.kiswich.codebuilder.service.ISqlService;
import top.kiswich.codebuilder.service.ITableService;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements ITableService {

    @Autowired
    ISqlService sqlService;
    @Autowired
    IMysqlService mysqlService;
    //用于分类的信息/与业务无关
    @Autowired
    IParseService parseService;
    @Autowired
    List<String> tableInfo;
    //前端返回的
    @Autowired
    TableMappingContainer tableMappingContainer;
    //可直接填充的
    @Autowired
    DatabaseFilling databaseFilling;
    //传给前端的数据库信息
    @Autowired
    DatabaseInfo databaseInfo;

    @Override
    public void getTables(Database database) throws Exception {
        Connection connect = mysqlService.getConnect(Integer.parseInt(database.getPort()), database.getHost(), database.getDbName(), database.getUsername(), database.getPassword());
        try {
            String ColumnName = sqlService.getShowtablesColun(database.getDbName());
            ArrayList<String> tableNames = new ArrayList<>();
            //读取表名
            try (
                    PreparedStatement preparedStatement = connect.prepareStatement(SqlConstant.SHOW_TABLES);
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                while (resultSet.next()) {
                    tableNames.add(resultSet.getString(ColumnName));
                }
            }
            Integer tableIndex = 0;
            //读取字段名
            for (String tableName : tableNames) {

                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setId(tableIndex);
                databaseInfo.getTableInfos().add(tableInfo);

                tableIndex++;

                PreparedStatement preparedStatement = connect.prepareStatement(sqlService.getColumInfoSql(tableName));
                ResultSet resultSet = preparedStatement.executeQuery();
                Integer columnIndex = 0;
                try {
                    while (resultSet.next()) {

                        ColumnInfo columnInfo = new ColumnInfo();
                        columnInfo.setId(columnIndex);
                        tableInfo.getColumnInfos().add(columnInfo);

                        columnIndex++;

                        for (String columnName : this.tableInfo) {
                            String string = resultSet.getString(columnName);
                            switch (columnName) {
                                case TableConstant.COMMENT:
                                    columnInfo.setColumComment(string);
                                    break;
                                case TableConstant.FIELD:
                                    columnInfo.setColumField(string);
                                    break;
                                case TableConstant.KEY:
                                    columnInfo.setColumKey(string);
                                    break;
                                case TableConstant.TYPE:
                                    columnInfo.setColumType(string.toLowerCase());
                                    break;
                            }
                        }
                    }
                } finally {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                }
            }

            databaseInfo.setDatabaseName(database.getDbName());
        } finally {
            if (connect != null) connect.close();
        }

    }

    /**
     * 将前端的表表映射关系转换为后端可以调用的映射关系
     */
    @Override
    public void setMapping() {
        //解析出所有的entity
        TableMapping tableMapping = tableMappingContainer.getTableMapping();
        tableMapping.getOneToOnes().forEach(this::parseOneToOne);
        tableMapping.getOneToManies().forEach(this::parseOneToMany);
        tableMapping.getManyToManies().forEach(this::parseManyToMany);
        tableMapping.getNormalTables().forEach(this::parseNormal);
        //根据entity匹配出其他的filling
        parseService.parse2Tamplate(databaseFilling);
    }

    public void clearAllData() {
        if (databaseInfo.getTableInfos() != null) databaseInfo.getTableInfos().clear();
        clearMapperData();
    }

    @Override
    public void clearMapperData() {
        if (databaseFilling.getErrorMessage() != null) databaseFilling.getErrorMessage().clear();
        if (databaseFilling.getEntityFillings() != null) databaseFilling.getEntityFillings().clear();
        if (databaseFilling.getControllerFillings() != null) databaseFilling.getControllerFillings().clear();
        if (databaseFilling != null) databaseFilling.setBase(null);
        if (databaseFilling.getHtmlFillings() != null) databaseFilling.getHtmlFillings().clear();
        if (databaseFilling.getJsFillings() != null) databaseFilling.getJsFillings().clear();
        if (databaseFilling.getRepositoryFillings() != null) databaseFilling.getRepositoryFillings().clear();
        if (databaseFilling.getServiceFillings() != null) databaseFilling.getServiceFillings().clear();
        if (databaseFilling.getServiceImplFillings() != null) databaseFilling.getServiceImplFillings().clear();
    }

    /**
     * 根据表名获取实体填充
     *
     * @return
     */
    private EntityFilling getEntityFilling(TableInfo tableInfo) {
        for (EntityFilling entityFilling : databaseFilling.getEntityFillings()) {
            if (entityFilling.getTableName().equals(tableInfo.getTableName())) return entityFilling;
        }
        //还没有这个表的填充类
        EntityFilling entityFilling = new EntityFilling()
                .setEntityName(parseService.parseTableName(tableInfo.getTableName()))
                .setTableName(tableInfo.getTableName())
                .setDbName(databaseInfo.getDatabaseName());
        databaseFilling.getEntityFillings().add(entityFilling);
        return entityFilling;
    }

    /**********************************以下代码我再也不想看到了************************************/
    private void parseOneToOne(OneToOne oneToOne) {
        try {
            TableNormal holdTable = oneToOne.getHoldTable();
            //持有外键的一方
            TableInfo holdTableInfo = databaseInfo.getTableInfos().get(holdTable.getTableId());
            ColumnInfo holdColumnInfo = holdTableInfo.getColumnInfos().get(holdTable.getForeignKeyId());

            TableNormal table = oneToOne.getTable();
            TableInfo tableInfo = databaseInfo.getTableInfos().get(table.getTableId());
//            ColumnInfo columnInfo = tableInfo.getColumnInfos().get(table.getForeignKeyId());

            String upperColumnName = parseService.parseTableName(holdTableInfo.getTableName());
            String firstLowName = parseService.parseFirstLowName(upperColumnName);
//            String type = parseService.parseType(columnInfo.getColumType());


            String upperHoldColumnName = parseService.parseTableName(tableInfo.getTableName());
            String holdFirstLowName = parseService.parseFirstLowName(upperHoldColumnName);
//            String hlodType = parseService.parseType(holdColumnInfo.getColumType());

            //映射类型和数据库本身类型没有关系
            String type = upperHoldColumnName + "Entity";
            String hlodType = upperColumnName + "Entity";

            //先找此类的类有无添加过，如有，则直接插入，想用二分查找...
            EntityFilling entityFilling = getEntityFilling(tableInfo);
            EntityFilling holdEntityFilling = getEntityFilling(holdTableInfo);

            entityFilling.getOneToOnes().getMapper().add(new OneToOneMapperFilling()
                    .setParamName(firstLowName)
                    .setType(hlodType)
                    .setMapperName(holdFirstLowName)
                    .setUpperParamName(upperColumnName));
            holdEntityFilling.getOneToOnes().getJoin().add(new OneToOneJoinFilling()
                    .setUpperParamName(upperHoldColumnName)
                    .setType(type)
                    .setParamName(holdFirstLowName)
                    .setComment(holdColumnInfo.getColumComment())
                    .setColumnName(holdColumnInfo.getColumField()));

        } catch (Exception e) {
            e.printStackTrace();
            databaseFilling.getErrorMessage().add(e.getMessage());

        }
    }

    private void parseOneToMany(OneToMany oneToMany) {
        TableNormal manyTable = oneToMany.getManyTable();
        TableNormal oneTable = oneToMany.getOneTable();

        TableInfo manyTableInfo = databaseInfo.getTableInfos().get(manyTable.getTableId());
        TableInfo oneTableInfo = databaseInfo.getTableInfos().get(oneTable.getTableId());
        ColumnInfo manyColumnInfo = manyTableInfo.getColumnInfos().get(manyTable.getForeignKeyId());

        String manyEntityName = parseService.parseTableName(manyTableInfo.getTableName());
        String oneEntityName = parseService.parseTableName(oneTableInfo.getTableName());

//        String firstLowOneEntityName = parseService.parseFirstLowName(oneEntityName);

        String upperManyColumnName = parseService.parseColumnName(manyColumnInfo.getColumField());
//        String manyColumnName = parseService.parseFirstLowName(upperManyColumnName);

        EntityFilling oneEntityFilling = getEntityFilling(oneTableInfo);
        EntityFilling manyEntityFilling = getEntityFilling(manyTableInfo);

        oneEntityFilling.getOneToManies().add(new OneToManyFilling()
                .setOneParamName("parent" + oneEntityName)
                .setParamName("child" + manyEntityName + "s")
                .setType(manyEntityName + "Entity")
                .setUpperParamName("Child" + manyEntityName + "s"));

        manyEntityFilling.getManyToOnes().add(new ManyToOneFilling()
                .setParamName("parent" + oneEntityName)
                .setComment(manyColumnInfo.getColumComment())
                .setType(oneEntityName + "Entity")
                .setUpperParamName("Parent" + oneEntityName)
                .setManyColumnName(manyColumnInfo.getColumField()));
    }

    private void parseManyToMany(ManyToMany manyToMany) {
        TableNormal table1 = manyToMany.getTable1();
        TableNormal table2 = manyToMany.getTable2();
        TableMid tableMid = manyToMany.getTableMid();

        TableInfo tableInfo1 = databaseInfo.getTableInfos().get(table1.getTableId());
        TableInfo tableInfo2 = databaseInfo.getTableInfos().get(table2.getTableId());
        TableInfo midTableInfo = databaseInfo.getTableInfos().get(tableMid.getTableId());

        ColumnInfo midFKey1 = midTableInfo.getColumnInfos().get(tableMid.getTable1().getForeignKeyId());
        ColumnInfo midFKey2 = midTableInfo.getColumnInfos().get(tableMid.getTable2().getForeignKeyId());

        ColumnInfo fKey1 = tableInfo1.getColumnInfos().get(tableMid.getTable1().getTableId());
        ColumnInfo fKey2 = tableInfo2.getColumnInfos().get(tableMid.getTable2().getTableId());

        EntityFilling entityFilling1 = getEntityFilling(tableInfo1);
        EntityFilling entityFilling2 = getEntityFilling(tableInfo2);

        String tableName1 = parseService.parseTableName(tableInfo1.getTableName());
        String tableName2 = parseService.parseTableName(tableInfo2.getTableName());

        String lowerTableName1 = parseService.parseFirstLowName(tableName1);
        String lowerTableName2 = parseService.parseFirstLowName(tableName2);

        entityFilling1.getManyToManies().getJoin().add(new ManyToManyJoinFilling()
                .setComment(fKey1.getColumComment())
                .setMappingId1(fKey1.getColumField())
                .setMappingId2(fKey2.getColumField())
                .setMidKey1(midFKey1.getColumField())
                .setMidKey2(midFKey2.getColumField())
                .setMidTableName(midTableInfo.getTableName())
                .setParamName(lowerTableName2 + "s")
                .setType(tableName2 + "Entity")
                .setUpperParamName(tableName2 + "s"));

        entityFilling2.getManyToManies().getMapper().add(new ManyToManyMapperFilling()
                .setComment(fKey2.getColumComment())
                .setMapperName(lowerTableName2 + "s")
                .setParamName(lowerTableName1 + "s")
                .setType(tableName1 + "Entity")
                .setUpperParamName(tableName1));

    }

    private void parseNormal(TableNormal tableNormal) {

        try {
            TableInfo tableInfo = databaseInfo.getTableInfos().get(tableNormal.getTableId());
            ColumnInfo columnInfo = tableInfo.getColumnInfos().get(tableNormal.getForeignKeyId());

            EntityFilling entityFilling = getEntityFilling(tableInfo);

            String columComment = columnInfo.getColumComment();
            String type = parseService.parseType(columnInfo.getColumType());
            String columName = columnInfo.getColumField();
            String entityParamName = parseService.parseColumnName(columName);
            String firstLowName = parseService.parseFirstLowName(entityParamName);

            if (columnInfo.getColumKey().contains("PRI")) {//主键

                entityFilling.setId(new ColumnFilling()
                        .setUpperParamName(entityParamName)
                        .setType(type)
                        .setParamNmae(firstLowName)
                        .setComment(columComment)
                        .setCloumnName(columName));
            } else {
                entityFilling.getNormalColumns().add(new ColumnFilling()
                        .setUpperParamName(entityParamName)
                        .setType(type)
                        .setParamNmae(firstLowName)
                        .setComment(columComment)
                        .setCloumnName(columName));
            }
        } catch (NoTypeMatchException e) {
            databaseFilling.getErrorMessage().add(e.getMessage());
        }
    }
}
