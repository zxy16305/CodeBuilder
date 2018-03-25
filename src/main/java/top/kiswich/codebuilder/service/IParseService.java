package top.kiswich.codebuilder.service;

import top.kiswich.codebuilder.exception.NoTypeMatchException;
import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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
    public String parseTableName(String tableName);

    /**
     * 将字段名转换成属性名
     * 规则是直接将下划线命名转为驼峰命名
     * @param columnName
     * @return
     */
    public String parseColumnName(String columnName);

    /**
     * 首字母小写
     * @return
     */
    public String parseFirstLowName(String string);

    /**
     * 将数据库中读出的类型转换成java中的类型
     * @param dataType
     * @return
     */
    public String parseType(String dataType) throws NoTypeMatchException;

    /**
     * 假定之前已经获取了entity的信息，现在只需要通过entity，就能将所有的填充类填充完整
     */
    public DatabaseFilling parse2Tamplate(DatabaseFilling databaseFilling);
}
