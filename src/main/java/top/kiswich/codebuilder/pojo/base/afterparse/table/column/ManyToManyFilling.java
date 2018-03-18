package top.kiswich.codebuilder.pojo.base.afterparse.table.column;

import top.kiswich.codebuilder.pojo.base.afterparse.table.column.ManyToManyJoinFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.ManyToManyMapperFilling;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换之后的模板填充类，
 * 用于填充ManyToMany部分的数据
 */
public class ManyToManyFilling {
    private List<ManyToManyJoinFilling> join;

    private List<ManyToManyMapperFilling> mapper;

    public ManyToManyFilling() {
        join = new ArrayList<>();
        mapper = new ArrayList<>();
    }

    public List<ManyToManyJoinFilling> getJoin() {
        return join;
    }

    public ManyToManyFilling setJoin(List<ManyToManyJoinFilling> join) {
        this.join = join;
        return this;
    }

    public List<ManyToManyMapperFilling> getMapper() {
        return mapper;
    }

    public ManyToManyFilling setMapper(List<ManyToManyMapperFilling> mapper) {
        this.mapper = mapper;
        return this;
    }
}
