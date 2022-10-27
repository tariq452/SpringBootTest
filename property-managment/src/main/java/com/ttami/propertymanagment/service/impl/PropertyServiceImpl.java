package com.ttami.propertymanagment.service.impl;


import com.ttami.propertymanagment.converter.PropertyConverter;
import com.ttami.propertymanagment.dto.PropertyDTO;

import com.ttami.propertymanagment.entity.PropertyEntity;
import com.ttami.propertymanagment.repository.PropertyRepository;
import com.ttami.propertymanagment.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<PropertyDTO> getAllProperties() {

        List<PropertyEntity> listOfProperties =(List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

      for( PropertyEntity pe: listOfProperties){
           PropertyDTO dto=propertyConverter.convertEntityToTDO(pe);
            propList.add(dto);

       }
        

        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
       PropertyDTO dto=null;
        Optional<PropertyEntity> optionalPropertyEntity =propertyRepository.findById(propertyId);
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe= optionalPropertyEntity.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwnerName(propertyDTO.getOwnerName());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setProce(propertyDTO.getProce());
            dto= propertyConverter.convertEntityToTDO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto=null;
        Optional<PropertyEntity> optionalPropertyEntity =propertyRepository.findById(propertyId);
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe= optionalPropertyEntity.get();
            pe.setDescription(propertyDTO.getDescription());
            dto= propertyConverter.convertEntityToTDO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        PropertyDTO dto=null;
        Optional<PropertyEntity> optionalPropertyEntity =propertyRepository.findById(propertyId);
        if (optionalPropertyEntity.isPresent()){
            PropertyEntity pe= optionalPropertyEntity.get();
            pe.setProce(propertyDTO.getProce());
            dto= propertyConverter.convertEntityToTDO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

}
