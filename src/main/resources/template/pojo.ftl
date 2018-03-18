package ${package}.entity.basic;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "${entity.tableName}", schema = "${entity.dbName}", catalog = "")
public class ${entity.entityName}Entity{
    //${entity.id.comment}
    private ${entity.id.type} ${entity.id.paramNmae};

<#list entity.normalColumns as value >
    //${value.comment}
    private ${value.type} ${value.paramNmae};
</#list>

<#list entity.oneToOnes as value>
    <#list value.join as join>
    //${join.comment}
    private ${join.type} ${join.paramName};
    </#list>

    <#list value.mapper as mapper>
    private ${mapper.type} ${mapper.paramName};
    </#list>
</#list>

<#list entity.manyToOnes as value>
    //${value.comment}
    private ${value.type} ${value.paramName};

</#list>

<#list entity.oneToManies as value>
    private List<${value.type}> ${value.paramName};

</#list>

<#list entity.manyToManies as value>
    <#list value.join as join>
    //${join.comment}
    private ${join.type} ${join.paramName};
    </#list>

    <#list value.mapper as mapper>
    //${mapper.comment}
    private ${mapper.type} ${mapper.paramName};
    </#list>
</#list>
    @Id
    @GeneratedValue
    @Column(name = "${entity.id.cloumnName}")
    public ${entity.id.type} get${entity.id.upperParamName}(){
        return this.${entity.id.paramNmae};
    }

    public void set${entity.id.upperParamName}(${entity.id.type} ${entity.id.paramNmae}){
        this.${entity.id.paramNmae} = ${entity.id.paramNmae};
    }

<#list entity.normalColumns as value >
    @Basic
    @Column(name = "${value.cloumnName}")
    public ${value.type} get${value.upperParamName}(){
        return this.${value.paramNmae};
    }

    public void set${value.upperParamName}(${value.type} ${value.paramNmae}){
        this.${value.paramNmae} = ${value.paramNmae};
    }

</#list>

<#list entity.oneToOnes as value>
    <#list value.join as join>
    @OneToOne()
    @JoinColumn(name = "${join.columnName}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ${join.type} get${join.upperParamName}(){
        return this.${join.paramName};
    }

    public void set${join.upperParamName}(${join.type} ${join.paramName}){
        this.${join.paramName} = ${join.paramName};
    }

    </#list>

    <#list value.mapper as mapper>
    @OneToOne(mappedBy = "${mapper.mapperName}",cascade = CascadeType.ALL,orphanRemoval = true)
    public ${mapper.type} get${mapper.upperParamName}(){
        return this.${mapper.paramName};
    }

    public void set${mapper.upperParamName}(${mapper.type} ${mapper.paramName}){
        this.${mapper.paramName} = ${mapper.paramName};
    }

    </#list>
</#list>

<#list entity.manyToOnes as value>
    @ManyToOne()
    @JoinColumn(name = "${value.manyColumnName}")
    @NotFound(action = NotFoundAction.IGNORE)
    public ${value.type} get${value.upperParamName}(){
        return ${value.paramName};
    }

    public void set${value.upperParamName}(${value.type} ${value.paramName}){
        this.${value.paramName} = ${value.paramName};
    }

</#list>

<#list entity.oneToManies as value>
    @OneToMany(mappedBy = "${value.oneParamName}")
    public List<${value.type}> get${value.upperParamName}() {
        return ${value.paramName};
    }

    public void set${value.upperParamName}(List<${value.type}> ${value.paramName}){
        this.${value.paramName} = ${value.paramName};
    }

</#list>

<#list entity.manyToManies as value>
    <#list value.join as join>
    @ManyToMany
    @JoinTable(name = "${join.midTableName}",
            joinColumns = {@JoinColumn(name="${join.midKey1}",referencedColumnName = "${join.mappingId1}")},
            inverseJoinColumns ={@JoinColumn(name="${join.midKey2}",referencedColumnName = "${join.mappingId2}")})
    @NotFound(action = NotFoundAction.IGNORE)
    public List<${join.type}> get${join.upperParamName}() {
        return this.${join.paramName};
    }

    public void set${join.upperParamName}(List<${join.type} ${join.upperParamName}) {
        this.${join.upperParamName} = ${join.upperParamName};
    }

    </#list>

    <#list value.mapper as mapper>
    @ManyToMany(mappedBy = "${mapper.mapperName}")
    public List<${mapper.type}> get${mapper.upperParamName}() {
        return this.${mapper.paramName};
    }

    public void set${mapper.upperParamName}(List<${mapper.type}> ${mapper.mapperName}) {
        this.${mapper.mapperName} = ${mapper.mapperName};
    }
    </#list>
</#list>
}