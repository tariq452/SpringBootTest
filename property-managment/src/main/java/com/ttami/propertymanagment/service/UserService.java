package com.ttami.propertymanagment.service;

import com.ttami.propertymanagment.dto.UserTDO;

public interface UserService {

    UserTDO register(UserTDO userTDO);
    UserTDO login(String emaill,String password);

}
