package top.kiswich.codebuilder.pojo.base.webFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.omg.CosNaming.IstringHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import top.kiswich.codebuilder.pojo.base.webFormat.in.ManyToMany;
import top.kiswich.codebuilder.pojo.base.webFormat.in.OneToMany;
import top.kiswich.codebuilder.pojo.base.webFormat.in.OneToOne;

import java.util.ArrayList;
import java.util.List;

/**
 * 前端传过来的表结构的映射关系字段
 * 在实体映射中需要4中，但是 OneToMany和ManyToOne是一样的
 * 因此传三种回来就可以了
 * <p>
 * 其中双向多对多映射，要创建中间类 emmmmm,好复杂
 * eg.(格式化了一下代码 就变这样了。。。。)
 * {@code
 * <p>
 * {
 * "oneToOnes":[
 * {
 * "table":{
 * "tableId":5,
 * "foreignKeyId":4
 * },
 * "holdTable":{
 * "tableId":7,
 * "foreignKeyId":6
 * }
 * }
 * ],
 * "oneToManies":[
 * {
 * "oneTable":{
 * "tableId":10,
 * "foreignKeyId":5
 * },
 * "manyTable":{
 * "tableId":9,
 * "foreignKeyId":2
 * }
 * }
 * ],
 * "manyToManies":[
 * {
 * "table1":{
 * "tableId":1,
 * "foreignKeyId":5
 * },
 * "table2":{
 * "tableId":2,
 * "foreignKeyId":5
 * },
 * "tableMid":{
 * "tableId":5,
 * "table1":{
 * "tableId":1,
 * "foreignKeyId":1
 * },
 * "table2":{
 * "tableId":2,
 * "foreignKeyId":2
 * }
 * }
 * }
 * ]
 * }
 * </p>
 */

@JsonIgnoreProperties
public class TableMapping {
    private List<OneToOne> oneToOnes;
    private List<OneToMany> oneToManies;
    private List<ManyToMany> manyToManies;

    public TableMapping() {
        oneToOnes = new ArrayList<>();
        oneToManies = new ArrayList<>();
        manyToManies = new ArrayList<>();
    }

    public List<OneToOne> getOneToOnes() {
        return oneToOnes;
    }

    public void setOneToOnes(List<OneToOne> oneToOnes) {
        this.oneToOnes = oneToOnes;
    }

    public List<OneToMany> getOneToManies() {
        return oneToManies;
    }

    public void setOneToManies(List<OneToMany> oneToManies) {
        this.oneToManies = oneToManies;
    }

    public List<ManyToMany> getManyToManies() {
        return manyToManies;
    }

    public void setManyToManies(List<ManyToMany> manyToManies) {
        this.manyToManies = manyToManies;
    }
}
