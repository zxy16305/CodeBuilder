package top.kiswich.codebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.pojo.base.beforeparse.ColumnInfo;
import top.kiswich.codebuilder.pojo.base.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.pojo.base.beforeparse.TableInfo;
import top.kiswich.codebuilder.pojo.common.SqlConstant;
import top.kiswich.codebuilder.pojo.common.TableConstant;
import top.kiswich.codebuilder.service.IMysqlService;
import top.kiswich.codebuilder.service.ISqlService;
import top.kiswich.codebuilder.service.ITableService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements ITableService {
    @Autowired
    DatabaseInfo databaseInfo;
    @Autowired
    ISqlService sqlService;
    @Autowired
    IMysqlService mysqlService;
    @Autowired
    List<String> tableInfo;

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
                tableIndex++;
                TableInfo tableInfo = new TableInfo();
                tableInfo.setTableName(tableName);
                tableInfo.setId(tableIndex);
                databaseInfo.getTableInfos().add(tableInfo);

                PreparedStatement preparedStatement = connect.prepareStatement(sqlService.getColumInfoSql(tableName));
                ResultSet resultSet = preparedStatement.executeQuery();
                Integer columnIndex = 0;
                try {
                    while (resultSet.next()) {
                        columnIndex++;
                        ColumnInfo columnInfo = new ColumnInfo();
                        columnInfo.setId(columnIndex);
                        tableInfo.getColumnInfos().add(columnInfo);

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
                                    columnInfo.setColumType(string);
                                    break;
                            }
                        }

                    }
                } finally {
                    if (resultSet != null) resultSet.close();
                    if (preparedStatement != null) preparedStatement.close();
                }
            }
        } finally {
            if (connect != null) connect.close();
        }

    }
}
