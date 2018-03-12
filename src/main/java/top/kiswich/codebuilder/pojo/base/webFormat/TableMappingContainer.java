package top.kiswich.codebuilder.pojo.base.webFormat;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * 管理mapping的容器
 */
@Component
@SessionScope
public class TableMappingContainer {
    private TableMapping tableMapping;

    public TableMapping getTableMapping() {
        return tableMapping;
    }

    public void setTableMapping(TableMapping tableMapping) {
        this.tableMapping = tableMapping;
    }
}
