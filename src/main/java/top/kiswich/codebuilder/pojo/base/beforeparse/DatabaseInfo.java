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

    private String thisPackage;
    private String author;
    private String email;


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

    public String getThisPackage() {
        return thisPackage;
    }

    public void setThisPackage(String thisPackage) {
        this.thisPackage = thisPackage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
