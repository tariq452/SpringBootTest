package com.ttami.propertymanagment.repository;


import com.ttami.propertymanagment.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity>findByOwnerEmailAndPassword(String email,String password);
}
