package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

import top.kiswich.codebuilder.pojo.base.afterparse.table.column.OneToOneJoinFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.OneToOneMapperFilling;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换之后的模板填充类，
 * 用于填充One2One部分的数据
 */
public class OneToOneFilling {
    private List<OneToOneJoinFilling> join;
    private List<OneToOneMapperFilling> mapper;

    public OneToOneFilling() {
        join = new ArrayList<>();
        mapper = new ArrayList<>();
    }

    public List<OneToOneJoinFilling> getJoin() {
        return join;
    }

    public OneToOneFilling setJoin(List<OneToOneJoinFilling> join) {
        this.join = join;
        return this;
    }

    public List<OneToOneMapperFilling> getMapper() {
        return mapper;
    }

    public OneToOneFilling setMapper(List<OneToOneMapperFilling> mapper) {
        this.mapper = mapper;
        return this;
    }
}
