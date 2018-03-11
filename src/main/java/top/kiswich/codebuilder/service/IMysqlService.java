package top.kiswich.codebuilder.service;

import java.sql.Connection;

/**
 * 用于管理mysql数据库的service
 */
public interface IMysqlService {
    /**
     * 获取mysql的jdbc链接
     * @param dbName
     * @param username
     * @param password
     * @return
     */
    public Connection getConnect(Integer port,String host,String dbName,String username,String password) throws Exception;


}
