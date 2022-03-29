package br.com.meli.desafio_quality.repository;


import br.com.meli.desafio_quality.entity.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository {
    Property addProperty(Property property);

    List<Property> getAllProperties();
}
