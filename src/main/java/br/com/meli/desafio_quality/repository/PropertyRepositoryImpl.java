package br.com.meli.desafio_quality.repository;

import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.exception.PropertyNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PropertyRepositoryImpl implements PropertyRepository{

    private static List<Property> properties = new ArrayList<>();

    public Property addProperty(Property property) {
        properties.add(property);
        return property;
    }

    @Override
    public List<Property> getAllProperties() {
        return properties;
    }

    @Override
    public Property getProperty(String propertyId) throws PropertyNotFoundException {
        return properties.stream().filter(prop -> prop.getId().equals(propertyId)).findFirst().orElseThrow(() -> new PropertyNotFoundException(propertyId));
    }

    @Override
    public void cleanAllProperties() {
        properties.clear();
    }
}
