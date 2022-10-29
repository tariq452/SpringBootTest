package com.ttami.propertymanagment.controller;


import com.ttami.propertymanagment.dto.UserTDO;
import com.ttami.propertymanagment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserTDO> registerUser(@Valid @RequestBody UserTDO userTDO){
        userTDO= userService.register(userTDO);
        return new ResponseEntity<>(userTDO, HttpStatus.CREATED);

    }


    @PostMapping("/login")
    public ResponseEntity<UserTDO> loginUser(@RequestBody UserTDO userTDO){
        userTDO= userService.login(userTDO.getOwnerEmail(),userTDO.getPassword());
        return new ResponseEntity<>(userTDO, HttpStatus.CREATED);

    }
}
