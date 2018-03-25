//package top.kiswich.codebuilder;
//
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
//
//import java.io.*;
//import java.util.HashMap;
//
//public class FreemakerTest {
//
//    public static void main(String[] args){
//        try {
//            InputStream resourceAsStream = FreemakerTest.class.getResourceAsStream("/template/html.ftl");
//            InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
//            Template template = new Template("controller",inputStreamReader);
//
//            DatabaseFilling databaseFilling = new DatabaseFilling();
//            databaseFilling.getList().add("list1");
//            databaseFilling.getList().add("list2");
//            databaseFilling.getList().add("list3");
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("test",databaseFilling);
//
//            StringWriter stringWriter = new StringWriter();
//            template.process(hashMap,stringWriter);
//            System.out.println(stringWriter.toString());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}
