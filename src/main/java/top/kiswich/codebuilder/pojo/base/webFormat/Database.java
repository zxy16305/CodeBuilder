package top.kiswich.codebuilder.pojo.base.webFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 前端传来的json
 */
@JsonIgnoreProperties
public class Database {
    private String host;
    private String port;
    private String username;
    private String password;
    private String dbName;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
