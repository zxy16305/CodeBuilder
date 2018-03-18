package ${base.thisPackage}.controller

import ${base.thisPackage}.entity.basic.${controller.upperName}Entity;




public interface I${service.upperName}Service{

    public ${service.upperName}Entity  add${service.upperName}(${service.upperName}Entity ${service.name}Entity) throws Exception;

    public void  remove${service.upperName}(${service.upperName}Entity ${service.name}Entity) throws Exception;

    public ${service.upperName}Entity update${service.upperName}(${service.upperName}Entity ${service.name}Entity) throws Exception;
}
