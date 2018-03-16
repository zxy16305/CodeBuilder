package top.kiswich.codebuilder.service;

import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;

/**
 * 有关于转换的业务逻辑
 */
public interface IParseService {

    /**
     * 将表名转换成对象名
     * 简单的规则就是去掉T_前缀
     * 然后将下划线命名改成驼峰命名
     * @param tableName
     * @return
     */
    public String parseTableName(String tableName) throws Exception;

    /**
     * 将字段名转换成属性名
     * 规则是直接将下划线命名转为驼峰命名
     * @param columnName
     * @return
     */
    public String parseColumnName(String columnName);

    /**
     * 直接从数据库中读取的表信息还不能明确表结构的关系
     * 因此不能得出完美的JPA标准注解的vto
     * 因此要在前端确认之后，将所得到的表结构关系传入后台
     * 然后经过这个方法进行转换，将数据库得到的表信息转换成能够直接填装模板的信息
     */
    public DatabaseFilling parse2Tamplate();
}
