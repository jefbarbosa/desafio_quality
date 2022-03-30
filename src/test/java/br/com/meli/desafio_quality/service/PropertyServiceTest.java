package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.LargestRoomAreaDTO;
import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.dto.PropertyPriceDTO;
import br.com.meli.desafio_quality.dto.PropertyTotalAreaDTO;
import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
import br.com.meli.desafio_quality.repository.PropertyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropertyServiceTest {

    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @BeforeEach
    private void initializeProperties() {
        MockitoAnnotations.openMocks(this);
        this.propertyService = new PropertyService(propertyRepository);
    }

    @Test
    public void findLargestRoomTest() {
        List<Room> rooms = Arrays.asList(
                new Room("kitchen", 300.0, 10.0),
                new Room("bedroom", 20.0, 10.0),
                new Room("living room", 10.0, 10.0)
                );
        District district = new District("Tijuca", BigDecimal.valueOf(100.0));
        Property property = new Property("XYZ-12345", "Tijuca",district, rooms);

        Mockito.when(propertyRepository.getProperty("XYZ-12345")).thenReturn(property);

        LargestRoomAreaDTO largestRoomAreaDTO = propertyService.findLargestRoom("XYZ-12345");

        assertEquals(3000.0, largestRoomAreaDTO.getTotalArea());
        assertEquals("kitchen", largestRoomAreaDTO.getRoomName());

    }
    @Test
    public void calculateTotalAreaPropertyTest() {
            List<Room> rooms = Arrays.asList(
                    new Room("kitchen", 300.0, 10.0),
                    new Room("bedroom", 20.0, 10.0),
                    new Room("living room", 10.0, 10.0)
            );
            District district = new District("Tijuca", BigDecimal.valueOf(100.0));
            Property property = new Property("XYZ-12345", "Tijuca",district, rooms);

            Mockito.when(propertyRepository.getProperty("XYZ-12345")).thenReturn(property);

            PropertyTotalAreaDTO propertyTotalAreaDTO = propertyService.calculateTotalArea(property.getId());

            assertEquals(3300.0, propertyTotalAreaDTO.getTotalArea());

    }
    @Test
    public void calculateProperty() {
        List<Room> rooms = Arrays.asList(
                new Room("kitchen", 300.0, 10.0),
                new Room("bedroom", 20.0, 10.0),
                new Room("living room", 10.0, 10.0)
        );
        District district = new District("Tijuca", BigDecimal.valueOf(100.0));
        Property property = new Property("XYZ-12345", "Tijuca",district, rooms);

        Mockito.when(propertyRepository.getProperty("XYZ-12345")).thenReturn(property);

        PropertyPriceDTO propertyPriceDTO = propertyService.calculateProperty(property.getId());

        assertEquals(new BigDecimal("330000.00"), propertyPriceDTO.getPrice());

    }


}
