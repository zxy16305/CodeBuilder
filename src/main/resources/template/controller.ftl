package ${base.thisPackage}.controller

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import ${base.thisPackage}.entity.basic.${controller.upperName}Entity;
import ${base.thisPackage}.service.I${controller.upperName}Service;
import ${base.thisPackage}.repository.${controller.upperName}Repository;
import ${base.thisPackage}.entity.common.*;

import java.util.List;


/**
 * @author ${base.author}
 * @email ${base.email}
 * @date ${base.datetime}
 */
@Controller
@RequestMapping("/v1/${controller.name}")
public class ${controller.upperName}Controller{

    @Autowired
    ${controller.upperName}Repository ${controller.name}Repository;
    @Autowired
    I${controller.upperName}Service ${controller.name}Service;

    @GetMapping("/page")
    @ResponseBody
    public RespJson getPage(Pageable pageable){
        Page<${controller.upperName}Entity> ${controller.name}Entities = ${controller.name}Repository.findAll(pageable);
        return new RespJson(${controller.name}Entities);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RespJson get${controller.upperName}(@PathVariable("id") Integer id){
        try {
            ${controller.upperName}Entity ${controller.name}Entity = ${controller.name}Repository.findOne(id);
            return  new RespJson(${controller.name}Entity);
        }catch (Exception e){
            return new RespJson(ResultCode.FAIL,e.getMessage());
        }

    }

    @PostMapping("/")
    @ResponseBody
    public RespJson add${controller.upperName}(@RequestBody ${controller.upperName}Entity ${controller.name}Entity){
        try {
            ${controller.upperName}Entity ${controller.name}Entity = ${controller.name}Service.add${controller.upperName}(${controller.name}Entity);
            return new RespJson(${controller.name}Entity);
        }catch (Exception e){
            return new RespJson(ResultCode.FAIL,e.getMessage());
        }
    }

    @DeleteMapping("/")
    @ResponseBody
    public RespJson remove${controller.upperName}(@RequestBody ${controller.upperName}Entity ${controller.name}Entity){
        try {
            ${controller.name}Service.remove${controller.upperName}(${controller.name}Entity);
            return new RespJson();
        }catch (Exception e){
            return new RespJson(ResultCode.FAIL,e.getMessage());
        }
    }

    @PutMapping("/")
    @ResponseBody
    public RespJson add${controller.upperName}(@RequestBody ${controller.upperName}Entity ${controller.name}Entity){
        try {
            ${controller.upperName}Entity ${controller.name}Entity = ${controller.name}Service.update${controller.upperName}(${controller.name}Entity);
            return new RespJson(${controller.name}Entity);
        }catch (Exception e){
            return new RespJson(ResultCode.FAIL,e.getMessage());
        }
    }
}