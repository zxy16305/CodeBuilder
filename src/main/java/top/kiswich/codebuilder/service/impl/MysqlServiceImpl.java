package top.kiswich.codebuilder.service.impl;

import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.service.IMysqlService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MysqlServiceImpl implements IMysqlService {


    private String getUrl(String dbName, Integer port, String host) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jdbc:mysql://")
                .append(host).append(":")
                .append(port).append("/")
                .append(dbName).append("?useSSL=true");
        return stringBuilder.toString();
    }

    @Override
    public Connection getConnect(Integer port, String host, String dbName, String username, String password) throws Exception {
        try {
            return DriverManager.getConnection(getUrl(dbName, port, host)
                    , username
                    , password);
        } catch (SQLException e) {
            throw new Exception("数据库链接出现问题，请检查连接参数");
        }
    }
}
