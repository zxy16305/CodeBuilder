package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

/**
 * manyToMany 作为mapper的一方
 */
public class ManyToManyMapperFilling {
    //填充属性
    private String type;
    //首字母小写的属性名
    private String paramName;
    //首字母大写的属性名
    private String upperParamName;

    //mapper对应的属性名
    private String mapperName;

    //注释
    private String comment;

    public String getType() {
        return type;
    }

    public ManyToManyMapperFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public ManyToManyMapperFilling setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public ManyToManyMapperFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }

    public String getMapperName() {
        return mapperName;
    }

    public ManyToManyMapperFilling setMapperName(String mapperName) {
        this.mapperName = mapperName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ManyToManyMapperFilling setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
