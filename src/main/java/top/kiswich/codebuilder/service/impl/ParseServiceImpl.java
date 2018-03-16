package top.kiswich.codebuilder.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.service.IParseService;

import java.util.Arrays;

@Service
public class ParseServiceImpl implements IParseService {
    @Autowired
    DatabaseInfo databaseInfo;

    @Override
    public String parseTableName(String tableName)  {
        if (tableName.startsWith("T")) tableName = tableName.substring(1);
        return  parseColumnName(tableName);
    }

    @Override
    public String parseColumnName(String columnName) {
        return Arrays.stream(columnName.split("_"))
                .filter(s -> s.length() > 0)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .reduce((s1, s2) -> s1 + s2).orElse(null);
    }

    @Override
    public DatabaseFilling parse2Tamplate() {
        DatabaseFilling databaseFilling = new DatabaseFilling();
        return null;
    }

    //测试通过
    @Test
    public void testString() {
        String s = parseColumnName("");
        System.out.println(s);

        String s2 = parseTableName("");
        System.out.println(s2);
    }
}
