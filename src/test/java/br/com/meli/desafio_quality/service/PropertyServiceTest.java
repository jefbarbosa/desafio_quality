package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.LargestRoomAreaDTO;
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
                new Room("cozinha", 300.0, 10.0),
                new Room("quarto", 20.0, 10.0),
                new Room("sala", 10.0, 10.0)
                );
        District district = new District("Tijuca", BigDecimal.valueOf(100.0));
        Property property = new Property("XYZ-12345", "Tijuca",district, rooms);

        Mockito.when(propertyRepository.getProperty("XYZ-12345")).thenReturn(property);

        LargestRoomAreaDTO largestRoomAreaDTO = propertyService.findLargestRoom("XYZ-12345");

        assertEquals(3000.0, largestRoomAreaDTO.getTotalArea());
        assertEquals("cozinha", largestRoomAreaDTO.getRoomName());

    }
}
