package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.LargestRoomAreaDTO;
import br.com.meli.desafio_quality.dto.PropertyPriceDTO;
import br.com.meli.desafio_quality.dto.PropertyTotalAreaDTO;
import br.com.meli.desafio_quality.dto.RoomAreasDTO;
import br.com.meli.desafio_quality.dto.PropertyDTO;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Classe de teste responsável por testes os metodos da classe PropertyService.
 * @author Jederson Macedo
 * @author Igor Nogueira
 * @author Arthur Guedes
 * @author Jeferson Barbosa
 */
public class PropertyServiceTest {

    private PropertyService propertyService;

    @Mock
    private PropertyRepository propertyRepository;

    @Mock
    private DistrictService districtService;

    @BeforeEach
    private void initializeProperties() {
        MockitoAnnotations.openMocks(this);
        this.propertyService = new PropertyService(propertyRepository, districtService);
    }

    /**
     * Encontra o maior comodo da propriedade.
     * @result LargestRoomAreaDTO  vai ser criado sem nenhum erro
     */
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
    /**
     * Valida o calculo da area total da propriedade.
     * @result PropertyTotalAreaDTO  vai ser criado sem nenhum erro
     */
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
    /**
     * Valida o calculo do preço da propriedade baseada no valor do m2 do bairro.
     * @result propertyPriceDTO  vai ser criado sem nenhum erro
     */
    @Test
    public void calculatePropertyTest() {
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
    /**
     * Valida o calculo da area de cada comodo da propriedade.
     * @result RoomAreasDTO  vai ser criado sem nenhum erro
     */
    @Test
    public void calculateRoomAreaTest(){
        List<Room> rooms = Arrays.asList(
                new Room("kitchen", 30.0, 10.0),
                new Room("bedroom", 20.0, 10.0),
                new Room("living room", 10.0, 10.0)
        );
        District district = new District("Tijuca", BigDecimal.valueOf(100.0));
        Property property = new Property("XYZ-12345", "Tijuca",district, rooms);

        Mockito.when(propertyRepository.getProperty("XYZ-12345")).thenReturn(property);

        RoomAreasDTO roomnsAreaDTO = propertyService.calculateAreaRooms(property.getId());

        assertEquals(300.0, roomnsAreaDTO.getRoomAreas().get("kitchen"));
        assertEquals(200.0, roomnsAreaDTO.getRoomAreas().get("bedroom"));
        assertEquals(100.0, roomnsAreaDTO.getRoomAreas().get("living room"));

    }
    /**
     * Gera propriedades para realizar testes.
     */
    private List<Property> generateProperties() {
        List<Property> properties = new ArrayList<>();

        List<Room> rooms1 = Arrays.asList(
                new Room("kitchen", 30.0, 10.0),
                new Room("bedroom", 20.0, 10.0),
                new Room("living room", 10.0, 10.0)
        );
        District district1 = new District("Tijuca Village", BigDecimal.valueOf(100.0));
        Property property1 = new Property("XYZ-12345", "Tijuca",district1, rooms1);

        List<Room> rooms2 = Arrays.asList(
                new Room("bedroom", 10.0, 4.0),
                new Room("kitchen", 10.0, 3.0),
                new Room("bathroom", 5, 5.0)
        );
        District district2 = new District("Moema", BigDecimal.valueOf(100.0));
        Property property2 = new Property("XYZ-123456", "Moema Village",district2, rooms2);

        properties.add(property1);
        properties.add(property2);

        return properties;
    }
    /**
     * Busca todas as propriedade.
     * @result List<PropertyDTO> devera ser criado sem nenhum erro
     */
    @Test
    public void getAllPropertiesToDtoTest() {
        List<Property> propertyList = generateProperties();
        Mockito.when(propertyRepository.getAllProperties()).thenReturn(propertyList);

        List<PropertyDTO> propertyDTOList = propertyService.getAllProperties();
        assertEquals("Tijuca", propertyDTOList.get(0).getName());
    }
    /**
     * Valida insersao de uma propriedade.
     * @result PropertyDTO devera ser criado sem nenhum erro
     */
    @Test
    public void insertPropertyTest() {
        List<Property> properties = generateProperties();

        Mockito.when(propertyRepository.addProperty(Mockito.any())).thenReturn(properties.get(0));

        PropertyDTO response = propertyService.insertProperty(PropertyDTO.propertyToDTO(properties.get(0)));

        assertEquals("XYZ-12345", response.getId());
    }

}
