package top.kiswich.codebuilder.pojo.base.beforeparse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试通过
 * 那 确实是这样的啊
 */
@Component
@SessionScope
public class DatabaseInfo {
    private Integer id;
    private String databaseName;

    private List<TableInfo> tableInfos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DatabaseInfo() {
        this.tableInfos = new ArrayList<>();
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public List<TableInfo> getTableInfos() {
        return tableInfos;
    }

    public void setTableInfos(List<TableInfo> tableInfos) {
        this.tableInfos = tableInfos;
    }
}
