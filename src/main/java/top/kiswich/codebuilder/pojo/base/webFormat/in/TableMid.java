package top.kiswich.codebuilder.pojo.base.webFormat.in;

/**
 * 中间表
 * 注意table1/talbe2中的tableId是对应表的Id，而foreignKeyId的值则是此表中外键的
 */
public class TableMid {
    private Integer tableId;
    private TableNormal table1;
    private TableNormal table2;

    public TableMid() {
    }

    public TableMid(Integer tableId, TableNormal table1, TableNormal table2) {
        this.tableId = tableId;
        this.table1 = table1;
        this.table2 = table2;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public TableNormal getTable1() {
        return table1;
    }

    public void setTable1(TableNormal table1) {
        this.table1 = table1;
    }

    public TableNormal getTable2() {
        return table2;
    }

    public void setTable2(TableNormal table2) {
        this.table2 = table2;
    }
}
