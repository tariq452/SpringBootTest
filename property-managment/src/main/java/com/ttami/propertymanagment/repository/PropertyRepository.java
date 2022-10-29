package com.ttami.propertymanagment.repository;

import com.ttami.propertymanagment.entity.PropertyEntity;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
    List<PropertyEntity> findAllByUserEntityId(Long userId);
}
