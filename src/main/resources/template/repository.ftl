package ${base.thisPackage}.repository

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ${base.thisPackage}.entity.basic.${repository.entityName}Entity;

@Repository
public interface ${repository.entityName}Repository extend CrudRepository
<${repository.entityName}Entity,Integer>{

}