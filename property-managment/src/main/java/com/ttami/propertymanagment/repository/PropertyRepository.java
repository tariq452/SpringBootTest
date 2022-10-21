package com.ttami.propertymanagment.repository;

import com.ttami.propertymanagment.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {
}
