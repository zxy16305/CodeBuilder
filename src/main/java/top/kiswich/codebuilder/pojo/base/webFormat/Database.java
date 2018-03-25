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

    private String thisPackage;
    private String author;
    private String email;

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
