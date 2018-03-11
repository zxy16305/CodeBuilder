package top.kiswich.codebuilder.pojo.base.beforeparse;

public class ColumnInfo {
    private Integer id;
    //字段名
    private String columField;
    //字段类型
    private String columType;
    //是否为主键 主键值为PRI
    private String columKey;
    //注释
    private String columComment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumField() {
        return columField;
    }

    public void setColumField(String columField) {
        this.columField = columField;
    }

    public String getColumType() {
        return columType;
    }

    public void setColumType(String columType) {
        this.columType = columType;
    }

    public String getColumKey() {
        return columKey;
    }

    public void setColumKey(String columKey) {
        this.columKey = columKey;
    }

    public String getColumComment() {
        return columComment;
    }

    public void setColumComment(String columComment) {
        this.columComment = columComment;
    }
}
