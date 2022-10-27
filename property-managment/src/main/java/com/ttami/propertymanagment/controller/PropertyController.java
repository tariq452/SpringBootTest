package com.ttami.propertymanagment.controller;


import com.ttami.propertymanagment.dto.PropertyDTO;
import com.ttami.propertymanagment.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@GetMapping("/properties")
  public ResponseEntity<List<PropertyDTO>> getAllProperties(){
    List<PropertyDTO> propertyDTOList= propertyService.getAllProperties();
    ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyDTOList,HttpStatus.OK);

      return responseEntity;
  }
@PutMapping("/properties/{propertyId}")
  public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId){
    propertyDTO=propertyService.updateProperty(propertyDTO,propertyId);
    ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
    return responseEntity;
  }
    @PutMapping("/properties/update-description/{propertyId}")
  public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO=propertyService.updatePropertyDescription(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;

  }
    @PutMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        propertyDTO=propertyService.updatePropertyPrice(propertyDTO,propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable  Long propertyId){
    propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>( HttpStatus.NO_CONTENT);

        return  responseEntity;
    }
}
