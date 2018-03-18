package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

/**
 * OneToOne作为mapper的一方 (字段不是自己管理）
 */
public class OneToOneMapperFilling {

    //mapper填充，即对应类的映射属性名
    private String mapperName;

    private String type;

    private String paramName;

    private String upperParamName;

    public String getMapperName() {
        return mapperName;
    }

    public OneToOneMapperFilling setMapperName(String mapperName) {
        this.mapperName = mapperName;
        return this;
    }

    public String getType() {
        return type;
    }

    public OneToOneMapperFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public OneToOneMapperFilling setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public OneToOneMapperFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }
}
