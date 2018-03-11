package top.kiswich.codebuilder.pojo.base.beforeparse;

import java.util.ArrayList;
import java.util.List;


public class TableInfo {
    private Integer id;

    private String tableName;

    private List<ColumnInfo> columnInfos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TableInfo() {
        columnInfos = new ArrayList<>();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }
}
