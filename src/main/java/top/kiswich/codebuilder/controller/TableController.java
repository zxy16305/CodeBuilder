package top.kiswich.codebuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kiswich.codebuilder.pojo.base.webFormat.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMapping;
import top.kiswich.codebuilder.pojo.base.webFormat.TableMappingContainer;
import top.kiswich.codebuilder.returnType.ObjectJson;
import top.kiswich.codebuilder.returnType.ResulrCode;
import top.kiswich.codebuilder.service.IParseService;
import top.kiswich.codebuilder.service.ITableService;

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

//    @GetMapping("/get")
//    public ObjectJson getTables(/*@RequestBody Database database*/){
//
//        return new ObjectJson(databaseInfo.getDatabaseName());
//    }
//
//    @PostMapping("/post")
//    public ObjectJson setTables(@RequestBody Database database){
//        databaseInfo.setDatabaseName(database.getDbName() == null ?"ceshi":database.getDbName());
//       return new ObjectJson();
//    }

    /**
     * 获取table信息和table中的字段信息
     */
    @GetMapping("/table")
    public ObjectJson getTables(@RequestBody Database database) {
        try {
            tableService.getTables(database);
            return new ObjectJson(databaseInfo.getTableInfos());
        } catch (Exception e) {
            return new ObjectJson(ResulrCode.FAIL, e.getMessage());
        }
    }

    @GetMapping("")
    public ObjectJson getZip(@RequestBody TableMapping tableMapping){
        tableMappingContainer.setTableMapping(tableMapping);
        parseService.parse2Tamplate();

    }


    @GetMapping("/test")
    public ObjectJson etst(@RequestBody Database database){
        return new ObjectJson(database);
    }
}
