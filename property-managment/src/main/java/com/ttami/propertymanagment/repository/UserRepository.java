package com.ttami.propertymanagment.repository;


import com.ttami.propertymanagment.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {
}
