package ${package}.repository

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ${package}.entity.basic.${repository.entityName}Entity;

@Repository
public interface ${entityName}Repository extend CrudRepository<${repository.entityName}Entity,Integer>{

}