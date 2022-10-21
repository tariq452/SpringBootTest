package com.ttami.propertymanagment.service.impl;

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

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity pe = new PropertyEntity();
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setOwnerName(propertyDTO.getOwnerName());
        pe.setOwnerEmail(propertyDTO.getOwnerEmail());
        pe.setProce(propertyDTO.getProce());
        propertyRepository.save(pe);

        return null;
    }
}
