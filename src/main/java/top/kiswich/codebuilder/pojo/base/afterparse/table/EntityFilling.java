package top.kiswich.codebuilder.pojo.base.afterparse.table;

import top.kiswich.codebuilder.pojo.base.afterparse.table.column.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的填充
 *
 * 这里稍微整一下
 * 除了oneToMany和ManyToOne的格式是确定的（一般都是多的一方管理外键）
 * oneToOne和manyToMany都有格式之分
 * oneToOne取决于谁管理外键，而manyToMany比较随意
 *
 * 现在还有个问题，controller层提供的接口和模板填充类里面是否应该全部处理好数据
 * 开始了开始了
 *
 */
public class EntityFilling {
    //@Table(name = "T_CRAD", schema = "${...}", catalog = "")
    private String dbName;
    //用于填充 @Table(name = "${...}", schema = "DB_MAPPING", catalog = "")
    private String tableName;
    //用于填充 public class ${...}
    private String entityName;

    //用于填充 id
    private ColumnFilling id;
    //除去id和映射之外的字段
    private List<ColumnFilling> normalColumns;

    private List<OneToOneFilling> oneToOnes;

    private List<ManyToOneFilling> manyToOnes;

    private List<OneToManyFilling> oneToManies;

    private List<ManyToManyFilling> manyToManies;


    public EntityFilling() {
        normalColumns = new ArrayList<>();
        oneToOnes = new ArrayList<>();
        manyToOnes = new ArrayList<>();
        oneToManies = new ArrayList<>();
        manyToManies = new ArrayList<>();
    }

    public String getDbName() {
        return dbName;
    }

    public EntityFilling setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public EntityFilling setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public String getEntityName() {
        return entityName;
    }

    public EntityFilling setEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    public ColumnFilling getId() {
        return id;
    }

    public EntityFilling setId(ColumnFilling id) {
        this.id = id;
        return this;
    }

    public List<ColumnFilling> getNormalColumns() {
        return normalColumns;
    }

    public EntityFilling setNormalColumns(List<ColumnFilling> normalColumns) {
        this.normalColumns = normalColumns;
        return this;
    }

    public List<OneToOneFilling> getOneToOnes() {
        return oneToOnes;
    }

    public EntityFilling setOneToOnes(List<OneToOneFilling> oneToOnes) {
        this.oneToOnes = oneToOnes;
        return this;
    }

    public List<ManyToOneFilling> getManyToOnes() {
        return manyToOnes;
    }

    public EntityFilling setManyToOnes(List<ManyToOneFilling> manyToOnes) {
        this.manyToOnes = manyToOnes;
        return this;
    }

    public List<OneToManyFilling> getOneToManies() {
        return oneToManies;
    }

    public EntityFilling setOneToManies(List<OneToManyFilling> oneToManies) {
        this.oneToManies = oneToManies;
        return this;
    }

    public List<ManyToManyFilling> getManyToManies() {
        return manyToManies;
    }

    public EntityFilling setManyToManies(List<ManyToManyFilling> manyToManies) {
        this.manyToManies = manyToManies;
        return this;
    }
}
