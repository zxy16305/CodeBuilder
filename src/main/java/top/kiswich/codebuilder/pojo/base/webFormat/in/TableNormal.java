package top.kiswich.codebuilder.pojo.base.webFormat.in;

/**
 * 普通表关系 只有一个表Id和外键columnId(甚至没有)
 */
public class TableNormal {
    private Integer tableId;
    private Integer foreignKeyId;

    public TableNormal() {
    }

    public TableNormal(Integer tableId, Integer foreignKeyId) {
        this.tableId = tableId;
        this.foreignKeyId = foreignKeyId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getForeignKeyId() {
        return foreignKeyId;
    }

    public void setForeignKeyId(Integer foreignKeyId) {
        this.foreignKeyId = foreignKeyId;
    }
}
