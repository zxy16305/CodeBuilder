package top.kiswich.codebuilder.service;

/**
 *  生成sql的业务
 *  因为在JDBC中，sql和得到的表，都会根据表明，字段名变化
 */
public interface ISqlService {

    /**
     * f返回输入show tables 后，表的字段名
     * @param databaseName
     * @return
     */
    public String  getShowtablesColun(String databaseName);

    /**
     * 根据表名生成查看表字段信息的SQL
     * @param tableName
     * @return
     */
    public String getColumInfoSql(String tableName);

}
