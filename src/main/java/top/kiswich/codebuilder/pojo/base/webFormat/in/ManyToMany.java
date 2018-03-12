package top.kiswich.codebuilder.pojo.base.webFormat.in;

public class ManyToMany {
    private TableNormal table1;
    private TableNormal table2;
    private  TableMid tableMid;

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

    public TableMid getTableMid() {
        return tableMid;
    }

    public void setTableMid(TableMid tableMid) {
        this.tableMid = tableMid;
    }
}
