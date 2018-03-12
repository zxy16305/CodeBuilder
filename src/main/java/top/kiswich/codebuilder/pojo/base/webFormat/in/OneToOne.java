package top.kiswich.codebuilder.pojo.base.webFormat.in;

public class OneToOne {
    private TableNormal table;
    private TableNormal holdTable;

    public TableNormal getTable() {
        return table;
    }

    public void setTable(TableNormal table) {
        this.table = table;
    }

    public TableNormal getHoldTable() {
        return holdTable;
    }

    public void setHoldTable(TableNormal holdTable) {
        this.holdTable = holdTable;
    }
}
