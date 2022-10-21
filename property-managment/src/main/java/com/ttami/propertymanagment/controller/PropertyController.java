package com.ttami.propertymanagment.controller;


import com.ttami.propertymanagment.dto.PropertyDTO;
import com.ttami.propertymanagment.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;
    @GetMapping("/hello")
  public String say(){

      return "hello";
  }
  @PostMapping("/properties")
  public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
      propertyDTO= propertyService.saveProperty(propertyDTO);
      ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
  }
}
