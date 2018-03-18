package ${base.thisPackage}.service.impl

import ${base.thisPackage}.entity.basic.${controller.upperName}Entity;
import ${base.thisPackage}.repository.${controller.upperName}Repository;
import ${base.thisPackage}.service.I${controller.upperName}Service;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ${serviceImpl.upperName}ServiceImpl implements I${serviceImpl.upperName}Service {

    @Autowired
    ${serviceImpl.upperName}Repository  ${serviceImpl.name}Repository;


    @Override
    public ${serviceImpl.upperName}Entity  add${serviceImpl.upperName}(${serviceImpl.upperName}Entity ${serviceImpl.name}Entity) throws Exception{
        ${serviceImpl.name}Repository.save(${serviceImpl.name}Entity);
    }

    @Override
    public void  remove${serviceImpl.upperName}(${serviceImpl.upperName}Entity ${serviceImpl.name}Entity) throws Exception{
        ${serviceImpl.name}Repository.delete(${serviceImpl.name}Entity);
    }

    @Override
    public ${serviceImpl.upperName}Entity update${serviceImpl.upperName}(${serviceImpl.upperName}Entity ${serviceImpl.name}Entity) throws Exception{
        ${serviceImpl.name}Repository.save(${serviceImpl.name}Entity);
    }
}