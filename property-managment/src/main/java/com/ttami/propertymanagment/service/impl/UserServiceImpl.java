package com.ttami.propertymanagment.service.impl;

import com.ttami.propertymanagment.converter.UserConverter;
import com.ttami.propertymanagment.dto.UserTDO;
import com.ttami.propertymanagment.entity.AddressEntity;
import com.ttami.propertymanagment.entity.PropertyEntity;
import com.ttami.propertymanagment.entity.UserEntity;
import com.ttami.propertymanagment.exception.BusinessException;
import com.ttami.propertymanagment.exception.ErrorModel;
import com.ttami.propertymanagment.repository.AddressReposoitory;
import com.ttami.propertymanagment.repository.UserRepository;
import com.ttami.propertymanagment.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressReposoitory addressReposoitory;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserTDO register(UserTDO userTDO) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(userTDO.getCity());
        addressEntity.setStreet(userTDO.getStreet());
        addressEntity.setCountry(userTDO.getCountry());
        addressEntity.setHouseNo(userTDO.getHouseNo());
        addressEntity.setPostalCode(userTDO.getPostalCode());
        UserEntity userEntity= modelMapper.map(userTDO,UserEntity.class);

        addressEntity.setUserEntity(userEntity);

        Optional<UserEntity> optionalUserEntity=userRepository.findByOwnerEmail(userTDO.getOwnerEmail());
        if (optionalUserEntity.isEmpty()){
            userRepository.save(userEntity);
            //userTDO=userConverter.convertEntityToTDO(userEntity);
            userTDO=modelMapper.map(userEntity, UserTDO.class);

            addressReposoitory.save(addressEntity);
            return userTDO;
        }else {

            List<ErrorModel> errorModels = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_REGISTER");
            errorModel.setMessage("The Email already exist");
            errorModels.add(errorModel);
            logger.error("Inside filed validation: {} - {} ",errorModel.getCode(),errorModel.getMessage());
            throw new BusinessException(errorModels);

        }

    }

    @Override
    public UserTDO login(String emaill, String password) {
        UserTDO userTDO=null;
        Optional<UserEntity> optionalUserEntity=userRepository.findByOwnerEmailAndPassword(emaill,password);
        if(optionalUserEntity.isPresent()){
           //userTDO=userConverter.convertEntityToTDO(optionalUserEntity);
            userTDO= modelMapper.map(optionalUserEntity, UserTDO.class);
        }else{
            List<ErrorModel> errorModels = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Emaill or Password");
            errorModels.add(errorModel);
            throw new BusinessException(errorModels);
        }
        return userTDO;
    }
}
