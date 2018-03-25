package top.kiswich.codebuilder.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.exception.NoTypeMatchException;
import top.kiswich.codebuilder.pojo.base.afterparse.*;
import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.service.IParseService;

import java.util.Arrays;
import java.util.List;

@Service
public class ParseServiceImpl implements IParseService {
    @Autowired
    DatabaseInfo databaseInfo;

    @Override
    public String parseTableName(String tableName) {
        if (tableName.startsWith("T")) tableName = tableName.substring(1);
        return parseColumnName(tableName);
    }

    @Override
    public String parseColumnName(String columnName) {
        return Arrays.stream(columnName.split("_"))
                .filter(s -> s.length() > 0)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .reduce((s1, s2) -> s1 + s2).orElse(null);
    }

    @Override
    public String parseFirstLowName(String string) {
        return string.substring(0, 1).toLowerCase() + string.substring(1);
    }

    @Override
    public String parseType(String dataType) throws NoTypeMatchException {
        if (dataType.contains("int")) {
            return "Integer";
        } else if (dataType.contains("char") || dataType.contains("text") || dataType.contains("blog")) {
            return "String";
        } else if (dataType.contains("date") || dataType.contains("time") || dataType.contains("year")) {
            return "Date";
        } else if (dataType.contains("float") || dataType.contains("double")) {
            return "double";
        }
        throw new NoTypeMatchException("No type matching type " + dataType);
    }

    @Override
    public DatabaseFilling parse2Tamplate(DatabaseFilling databaseFilling) {
        for (EntityFilling entityFilling : databaseFilling.getEntityFillings()) {
            String upperName = entityFilling.getEntityName();
            String name = parseFirstLowName(upperName);

            databaseFilling.getServiceImplFillings().add(new ServiceImplFilling()
                    .setName(name)
                    .setUpperName(upperName));

            databaseFilling.getServiceFillings().add(new ServiceFilling()
                    .setName(name)
                    .setUpperName(upperName));

            databaseFilling.getRepositoryFillings().add(new RepositoryFilling()
                    .setEntityName(upperName));

            databaseFilling.getControllerFillings().add(new ControllerFilling()
                    .setName(name)
                    .setUpperName(upperName));

            databaseFilling.getJsFillings().add(new JsFilling());

            databaseFilling.getHtmlFillings().add(new HtmlFilling());
        }
        return databaseFilling;
    }

    //测试通过
    @Test
    public void testString() {
        String s = parseColumnName("");
        System.out.println(s);

        String s2 = parseTableName("");
        System.out.println(s2);

        System.out.println(parseFirstLowName("UpJiKi"));
    }
}
