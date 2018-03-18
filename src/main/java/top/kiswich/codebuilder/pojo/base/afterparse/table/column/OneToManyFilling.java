package top.kiswich.codebuilder.pojo.base.afterparse.table.column;
/**
 * 转换之后的模板填充类，
 * 用于填充OneToMany部分的数据
 */
public class OneToManyFilling {
    //用于填充mappedBy=${...},即对应类中的字段名
    private String oneParamName;

    //用于填充List<${...}>，对应类的类名
    private String type;
    //填充变量名，在set类名的时候注入，即本类中的字段名
    private String paramName;
    //首字母大写的变量名
    private String upperParamName;

    public String getOneParamName() {
        return oneParamName;
    }

    public OneToManyFilling setOneParamName(String oneParamName) {
        this.oneParamName = oneParamName;
        return this;
    }

    public String getType() {
        return type;
    }

    public OneToManyFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public OneToManyFilling setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public OneToManyFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }
}
