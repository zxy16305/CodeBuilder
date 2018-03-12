package top.kiswich.codebuilder.pojo.base.webFormat.in;

public class OneToMany {
    private TableNormal oneTable;
    private TableNormal manyTable;

    public TableNormal getOneTable() {
        return oneTable;
    }

    public void setOneTable(TableNormal oneTable) {
        this.oneTable = oneTable;
    }

    public TableNormal getManyTable() {
        return manyTable;
    }

    public void setManyTable(TableNormal manyTable) {
        this.manyTable = manyTable;
    }
}
