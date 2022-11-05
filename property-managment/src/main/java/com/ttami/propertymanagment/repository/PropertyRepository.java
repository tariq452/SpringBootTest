package com.ttami.propertymanagment.repository;

import com.ttami.propertymanagment.entity.PropertyEntity;


import org.springframework.data.repository.CrudRepository;


import java.util.List;


public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
//    @Query("SELECT p from PropertyEntity p WHERE p.userEntity.id=:userId AND p.title=:title")
//    List<PropertyEntity> findAllByUserEntityId(@Param("userId")Long userId,@Param("title")String title);
    List<PropertyEntity> findAllByUserEntityId(Long userId);
}
