package top.kiswich.codebuilder.service;

import top.kiswich.codebuilder.pojo.base.beforeparse.TableInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMapping;

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


    /**
     * 将前端的表表映射关系转换为后端可以调用的映射关系
     */
    public void setMapping();

    /**
     * 清空之前的所有数据
     */
    public void clearAllData();

    /**
     * 清空匹配的数据
     */
    public void clearMapperData();

}
