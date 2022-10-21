package com.ttami.propertymanagment.service.impl;


import com.ttami.propertymanagment.converter.PropertyConverter;
import com.ttami.propertymanagment.dto.PropertyDTO;

import com.ttami.propertymanagment.entity.PropertyEntity;
import com.ttami.propertymanagment.repository.PropertyRepository;
import com.ttami.propertymanagment.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity pe = propertyConverter.covertDTOtoEntity(propertyDTO);
        pe = propertyRepository.save(pe);
        propertyDTO=propertyConverter.convertEntityToTDO(pe);


        return propertyDTO;
    }
}
