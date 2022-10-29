package com.ttami.propertymanagment.converter;



import com.ttami.propertymanagment.dto.UserTDO;

import com.ttami.propertymanagment.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity covertDTOtoEntity(UserTDO userTDO){

        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerEmail(userTDO.getOwnerEmail());
        userEntity.setPhone(userTDO.getPhone());
        userEntity.setPassword(userTDO.getPassword());
        userEntity.setOwnerName(userTDO.getOwnerName());
        return userEntity;
    }

    public UserTDO convertEntityToTDO (UserEntity userEntity){

        UserTDO  userTDO = new UserTDO();
        userTDO.setId(userEntity.getId());
        userTDO.setOwnerEmail(userEntity.getOwnerEmail());
        userTDO.setPhone(userEntity.getPhone());
        userTDO.setOwnerName(userEntity.getOwnerName());
        return userTDO;
    }
}
