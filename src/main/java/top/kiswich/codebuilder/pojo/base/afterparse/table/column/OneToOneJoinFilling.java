package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

/**
 * oneToOne作为join的一方（由自己管理字段）
 */
public class OneToOneJoinFilling {

    //join的字段名
    private String columnName;
    //类型
    private String type;
    //属性名
    private String paramName;
    //首字母大写的属性名
    private String upperParamName;

    private String comment;


    public String getColumnName() {
        return columnName;
    }

    public OneToOneJoinFilling setColumnName(String columnName) {
        this.columnName = columnName;
        return this;
    }

    public String getType() {
        return type;
    }

    public OneToOneJoinFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public OneToOneJoinFilling setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public OneToOneJoinFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public OneToOneJoinFilling setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
