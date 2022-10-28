package com.ttami.propertymanagment.service.impl;

import com.ttami.propertymanagment.converter.UserConverter;
import com.ttami.propertymanagment.dto.UserTDO;
import com.ttami.propertymanagment.entity.UserEntity;
import com.ttami.propertymanagment.repository.UserRepository;
import com.ttami.propertymanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Override
    public UserTDO register(UserTDO userTDO) {
        UserEntity userEntity= userConverter.covertDTOtoEntity(userTDO);
        userRepository.save(userEntity);
        userTDO=userConverter.convertEntityToTDO(userEntity);
        return userTDO;
    }

    @Override
    public UserTDO login(String emaill, String password) {
        return null;
    }
}
