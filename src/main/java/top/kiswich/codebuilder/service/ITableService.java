package top.kiswich.codebuilder.service;

import top.kiswich.codebuilder.pojo.base.webFormat.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;

/**
 * JDBC查表封装
 * 和有关于表的业务
 */
public interface ITableService {
    /**
     * 查询表的相关数据 完成封装 并加入 {@link DatabaseInfo}
     * 这是一个处在session域的对象
     * spring通过子类代理的方式来实现
     * @param database
     */
    public void getTables(Database database) throws Exception;


}
