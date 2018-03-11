package top.kiswich.codebuilder.service.impl;

import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.pojo.common.SqlConstant;
import top.kiswich.codebuilder.pojo.common.TableConstant;
import top.kiswich.codebuilder.service.ISqlService;

@Service
public class SqlServiceImpl implements ISqlService {
    @Override
    public String getShowtablesColun(String databaseName) {
        return SqlConstant.SHOW_TABLES_COLUM_NAME + databaseName.toLowerCase();
    }

    @Override
    public String getColumInfoSql(String tableName) {
        return SqlConstant.SHOW_COLUM_INFO + tableName;
    }
}
