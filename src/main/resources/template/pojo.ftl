

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "${entity.tableName}", schema = "${entity.db.dbName}", catalog = "")
public class ${entity.name}Entity{

<#list entity.protities as value >
    private ${value.type} ${value.name};
</#list>

<#list entity.manyToManyFillings as value>


</#list>

<#list entity.oneToManyFillings as value>


</#list>

<#list entity.manytoOneFillings as value>


</#list>

<#list entity.oneToOneFillings as value>


</#list>



<#list entity.protities as value >
    private ${value.type} ${value.name};
</#list>

<#list entity.manyToManyFillings as value>


</#list>

<#list entity.oneToManyFillings as value>


</#list>

<#list entity.manytoOneFillings as value>


</#list>

<#list entity.oneToOneFillings as value>


</#list>



    @Override
    public String toString() {
        return "${entity.name}Entity{" +
                <#list entity.protities as value>
                    "${entity.name}${value.name}=" + ${value.name} +
                </#list>
                '}';
    }


}