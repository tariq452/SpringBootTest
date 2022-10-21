package com.ttami.propertymanagment.service;

import com.ttami.propertymanagment.dto.PropertyDTO;
import com.ttami.propertymanagment.repository.PropertyRepository;

public interface PropertyService {


    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
}
