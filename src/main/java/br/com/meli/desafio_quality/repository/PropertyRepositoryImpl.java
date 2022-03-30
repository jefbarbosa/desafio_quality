package br.com.meli.desafio_quality.repository;

import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.entity.Property;
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
    public Property getProperty(String propertyId) {
        return properties.stream().filter(prop -> prop.getId().equals(propertyId)).findFirst().orElse(new Property());
    }

    @Override
    public void cleanAllProperties() {
        properties.clear();
    }
}
