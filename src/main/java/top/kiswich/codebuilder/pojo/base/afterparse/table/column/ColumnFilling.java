package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

/**
 * 列填充
 */
public class ColumnFilling {
    //字段名
    private String cloumnName;
    //属性类型（java中的）
    private String type;
    //属性名（根据字段名转变）
    private String paramNmae;
    //首字母大写的属性名
    private String upperParamName;

    //字段注释
    private String comment;

    public String getCloumnName() {
        return cloumnName;
    }

    public ColumnFilling setCloumnName(String cloumnName) {
        this.cloumnName = cloumnName;
        return this;
    }

    public String getType() {
        return type;
    }

    public ColumnFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamNmae() {
        return paramNmae;
    }

    public ColumnFilling setParamNmae(String paramNmae) {
        this.paramNmae = paramNmae;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public ColumnFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ColumnFilling setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
