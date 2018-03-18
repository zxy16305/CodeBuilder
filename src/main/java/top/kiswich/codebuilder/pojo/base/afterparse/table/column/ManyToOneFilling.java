package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

import com.fasterxml.jackson.core.SerializableString;

/**
 * 转换之后的模板填充类，
 * 用于填充ManyToMany部分的数据
 */
public class ManyToOneFilling {
    //用于填充 @JoinColumn(name = "${...}")，即本表中的字段名
    private String manyColumnName;

    //用于List变量类型，即对应类的类名
    private String type;
    //用于填充变量名
    private String paramName;
    //首字母大写的变量名
    private String upperParamName;

    private String comment;

    public String getManyColumnName() {
        return manyColumnName;
    }

    public ManyToOneFilling setManyColumnName(String manyColumnName) {
        this.manyColumnName = manyColumnName;
        return this;
    }


    public String getType() {
        return type;
    }

    public ManyToOneFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public ManyToOneFilling setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public ManyToOneFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ManyToOneFilling setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
