package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

/**
 * manyToMany作为join的一方，
 * 这一方需要注入中间表
 * 填充模板
 *
 * @ManyToMany
 * @JoinTable(name = "T_DEPT_USER",
 * joinColumns = {@JoinColumn(name="user_id",referencedColumnName = "id")},
 * inverseJoinColumns ={@JoinColumn(name="dept_id",referencedColumnName = "id")})
 * @NotFound(action = NotFoundAction.IGNORE)
 * public List<DeptEntity> getDepts() {
 * return depts;
 * }
 */
public class ManyToManyJoinFilling {

    //中间表名称
    private String midTableName;
    private String midKey1;
    private String mappingId1;
    private String midKey2;
    private String mappingId2;

    //填充属性
    private String type;
    //首字母小写的属性名
    private String paramName;
    //首字母大写的属性名
    private String upperParamName;
    //注释
    private String comment;


    public String getMidTableName() {
        return midTableName;
    }

    public ManyToManyJoinFilling setMidTableName(String midTableName) {
        this.midTableName = midTableName;
        return this;
    }

    public String getMidKey1() {
        return midKey1;
    }

    public ManyToManyJoinFilling setMidKey1(String midKey1) {
        this.midKey1 = midKey1;
        return this;
    }

    public String getMappingId1() {
        return mappingId1;
    }

    public ManyToManyJoinFilling setMappingId1(String mappingId1) {
        this.mappingId1 = mappingId1;
        return this;
    }

    public String getMidKey2() {
        return midKey2;
    }

    public ManyToManyJoinFilling setMidKey2(String midKey2) {
        this.midKey2 = midKey2;
        return this;
    }

    public String getMappingId2() {
        return mappingId2;
    }

    public ManyToManyJoinFilling setMappingId2(String mappingId2) {
        this.mappingId2 = mappingId2;
        return this;
    }

    public String getType() {
        return type;
    }

    public ManyToManyJoinFilling setType(String type) {
        this.type = type;
        return this;
    }

    public String getParamName() {
        return paramName;
    }

    public ManyToManyJoinFilling setParamName(String paramName) {
        this.paramName = paramName;
        return this;
    }

    public String getUpperParamName() {
        return upperParamName;
    }

    public ManyToManyJoinFilling setUpperParamName(String upperParamName) {
        this.upperParamName = upperParamName;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public ManyToManyJoinFilling setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
