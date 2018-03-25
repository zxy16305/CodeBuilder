package top.kiswich.codebuilder.service.impl;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.kiswich.codebuilder.pojo.base.afterparse.BaseImfFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
import top.kiswich.codebuilder.pojo.base.afterparse.table.EntityFilling;
import top.kiswich.codebuilder.service.ITemplateService;

import java.io.*;
import java.util.HashMap;

@Service
public class TemplateServiceImpl implements ITemplateService {

    @Autowired
    DatabaseFilling databaseFilling;

    @Override
    public void fillTemplate() {
        File file = new File("D:\\tt");
        if (!file.exists()) file.mkdirs();
        BaseImfFilling baseImfFilling = new BaseImfFilling()
                .setAuthor("zqw")
                .setEmail("zxy16305@gmail,com")
                .setThisPackage("top.kiswich");
        for (EntityFilling entityFilling : databaseFilling.getEntityFillings()) {

            File entityFile = new File(file, entityFilling.getEntityName() + "Entity.java");
            if (entityFile.exists()) entityFile.delete();
            try (
                    OutputStreamWriter outputStreamWriter = new FileWriter(entityFile)
            ) {

                HashMap<String, Object> hashMap = new HashMap<String, Object>() {{
                    put("base", baseImfFilling);
                    put("entity", entityFilling);
                }};

                InputStream inputStream = this.getClass().getResourceAsStream("/template/entity.ftl");
                Template entityTemplate = new Template("entity", new InputStreamReader(inputStream));
                entityTemplate.process(hashMap, outputStreamWriter);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (TemplateException e) {
                e.printStackTrace();
            }


        }


    }
}
