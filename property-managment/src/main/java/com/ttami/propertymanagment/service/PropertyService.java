package com.ttami.propertymanagment.service;

import com.ttami.propertymanagment.dto.PropertyDTO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {


     PropertyDTO saveProperty(PropertyDTO propertyDTO);

     List<PropertyDTO> getAllProperties( );

     List<PropertyDTO> getAllPropertiesForUser( Long userId);
     PropertyDTO updateProperty(PropertyDTO propertyDTO,Long propertyId);
     PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId);
     PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyId);
     void deleteProperty(Long propertyId );
}
