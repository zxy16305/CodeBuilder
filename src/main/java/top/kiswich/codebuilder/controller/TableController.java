package top.kiswich.codebuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import top.kiswich.codebuilder.pojo.base.afterparse.DatabaseFilling;
import top.kiswich.codebuilder.pojo.base.beforeparse.TableInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.Base;
import top.kiswich.codebuilder.pojo.base.webFormat.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMapping;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMappingContainer;
import top.kiswich.codebuilder.returnType.ObjectJson;
import top.kiswich.codebuilder.returnType.ResultCode;
import top.kiswich.codebuilder.service.IParseService;
import top.kiswich.codebuilder.service.ITableService;
import top.kiswich.codebuilder.service.ITemplateService;

import java.io.IOException;
import java.io.OutputStream;

@RestController
public class TableController {

    @Autowired
    ITableService tableService;
    @Autowired
    DatabaseInfo databaseInfo;
    @Autowired
    TableMappingContainer tableMappingContainer;
    @Autowired
    IParseService parseService;
    @Autowired
    DatabaseFilling databaseFilling;
    @Autowired
    ITemplateService templateService;

    /**
     * 获取table信息和table中的字段信息
     */
    @GetMapping("/table")
    public ObjectJson getTables(@RequestBody Database database) {
        try {
            tableService.clearAllData();
            tableService.getTables(database);

            databaseInfo.setThisPackage(database.getThisPackage());
            databaseInfo.setAuthor(database.getAuthor());
            databaseInfo.setEmail(database.getEmail());

            return new ObjectJson(databaseInfo.getTableInfos());
        } catch (Exception e) {
            return new ObjectJson(ResultCode.FAIL, e.getMessage());
        }
    }

    /**
     * 配置字段映射关系
     *
     * @param tableMapping
     * @return
     */
    @PostMapping("/mapping")
    public ObjectJson mappingData(@RequestBody TableMapping tableMapping) {
        tableService.clearMapperData();
        tableMappingContainer.setTableMapping(tableMapping);
        tableService.setMapping();
        templateService.fillTemplate();
        return new ObjectJson(databaseFilling.getEntityFillings());
    }

    /**
     * 向前端展示转换完成的代码
     *
     * @return
     */
    @GetMapping("/showing")
    public ObjectJson showCodes() {

        return new ObjectJson();
    }

    /**
     * 将程序打包下载 如果不预览，则为选择全部打包下载
     * 预览过后 则将选择的代码进行下载
     *
     * @param tableMapping
     * @return
     */
    @GetMapping("/download")
    public StreamingResponseBody getZip(@RequestBody TableMapping tableMapping) {
        tableMappingContainer.setTableMapping(tableMapping);
        parseService.parse2Tamplate(databaseFilling);

        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {

            }
        };
    }


    @GetMapping("/test")
    public ObjectJson test(@RequestBody Database database) {
        return new ObjectJson(database);
    }
}
