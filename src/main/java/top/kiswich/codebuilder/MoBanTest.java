package top.kiswich.codebuilder;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;
import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.ColumnFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.OneToOneFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.OneToOneJoinFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.column.OneToOneMapperFilling;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class MoBanTest {
    @Test
    public void testMuban() throws IOException, TemplateException {

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/template/entity.ftl");
        Template template = new Template("entitydd", new InputStreamReader(resourceAsStream));

        EntityFilling entityFilling = new EntityFilling();
        ArrayList<ColumnFilling> normalColumns = new ArrayList<ColumnFilling>() {{
            add(new ColumnFilling()
                    .setCloumnName("user_name")
                    .setComment("用户名")
                    .setParamNmae("username")
                    .setType("String")
                    .setUpperParamName("Username"));
            add(new ColumnFilling()
                    .setCloumnName("pass_word")
                    .setComment("密码")
                    .setParamNmae("password")
                    .setType("String")
                    .setUpperParamName("Password"));
        }};

        ArrayList<OneToOneFilling> oneToOneFillings = new ArrayList<OneToOneFilling>() {{
            add(new OneToOneFilling()
                    .setJoin(new ArrayList<OneToOneJoinFilling>() {{
                        add(new OneToOneJoinFilling()
                                .setColumnName("user_id")
                                .setComment("用户")
                                .setParamName("user")
                                .setType("UserEntity")
                                .setUpperParamName("User"));
                    }})
                    .setMapper(new ArrayList<OneToOneMapperFilling>() {{
                        add(new OneToOneMapperFilling()
                                .setMapperName("user")
                                .setParamName("card")
                                .setType("CardEntity")
                                .setUpperParamName("Card"));

                    }}));
        }};

        entityFilling.setDbName("DB_SC_CORE")
                .setEntityName("User")
                .setTableName("T_USER")

                .setId(new ColumnFilling()
                        .setCloumnName("id")
                        .setComment("主键")
                        .setParamNmae("id")
                        .setType("int")
                        .setUpperParamName("Id"))
                .setNormalColumns(normalColumns)
//                .setOneToOnes(oneToOneFillings)
//                .setOneToManies()
//                .setManyToOnes()
//                .setManyToManies()
        ;

        HashMap<String, Object> map = new HashMap<String, Object>() {{
            put("package", "top.kiswich");
            put("entity", entityFilling);
        }};

        StringWriter stringWriter = new StringWriter();
        template.process(map, stringWriter);
        System.out.println(stringWriter.toString());

    }
}
