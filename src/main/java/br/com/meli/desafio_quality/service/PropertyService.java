package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public PropertyDTO insertProperty(PropertyDTO propertyDTO) {
        return PropertyDTO.propertyToDTO(propertyRepository.addProperty(PropertyDTO.dtoToProperty(propertyDTO)));
    }

    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.getAllProperties().stream().map(PropertyDTO::propertyToDTO).collect(Collectors.toList());
    }
}
