package top.kiswich.codebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.service.IParseService;

@Service
public class ParseServiceImpl implements IParseService{
    @Autowired
    DatabaseInfo databaseInfo;

    @Override
    public String parseTableName(String tableName) {
        return null;
    }

    @Override
    public String parseColumnName(String columnName) {
        return null;
    }

    @Override
    public DatabaseFilling parse2Tamplate() {
        DatabaseFilling databaseFilling = new DatabaseFilling();
        return null;
    }
}
