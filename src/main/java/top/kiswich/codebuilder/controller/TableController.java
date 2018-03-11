package top.kiswich.codebuilder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.kiswich.codebuilder.pojo.base.Database;
import top.kiswich.codebuilder.pojo.base.beforeparse.DatabaseInfo;
import top.kiswich.codebuilder.returnType.ObjectJson;
import top.kiswich.codebuilder.returnType.ResulrCode;
import top.kiswich.codebuilder.service.ITableService;

@RestController
public class TableController {

    @Autowired
    ITableService tableService;


    @Autowired
    DatabaseInfo databaseInfo;

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
}
