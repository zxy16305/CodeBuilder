package top.kiswich.codebuilder.pojo.base.afterparse.table;

import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于模板填装
 * 最高层的封装
 */
public class DatabaseFilling {
    private List<EntityFilling> entities;

    public DatabaseFilling() {
        entities = new ArrayList<>();
    }

    public List<EntityFilling> getEntities() {
        return entities;
    }

    public DatabaseFilling setEntities(List<EntityFilling> entities) {
        this.entities = entities;
        return this;
    }
}
