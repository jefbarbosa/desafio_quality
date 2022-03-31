package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.*;
import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
import br.com.meli.desafio_quality.repository.DistrictRepository;
import br.com.meli.desafio_quality.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe Service responsável pelos serviços do recurso Property
 * @author Jeferson Barbosa
 * @author Arthur Guedes
 * @author Lucas Troleiz
 * @author Igor Nogueira
 */
@Service
@AllArgsConstructor


public class PropertyService {

    /**
     * {@link PropertyRepository Repository} de property injetado
     */
    @Autowired
    private PropertyRepository propertyRepository;

    /**
     * {@link DistrictService Service} de property injetado
     */
    @Autowired
    private DistrictService districtService;

    /**
     * Insere uma nova propriedade
     * @param propertyDTO Uma propriedade
     * @return Propriedade inserida
     */
    public PropertyDTO insertProperty(PropertyDTO propertyDTO) {
        districtService.findDistrict(propertyDTO.getDistrict().getName());

        return PropertyDTO.propertyToDTO(propertyRepository.addProperty(PropertyDTO.dtoToProperty(propertyDTO)));
    }

    /**
     * Obtém a lista de propriedades
     * @return Lista de propriedades
     */
    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.getAllProperties().stream().map(PropertyDTO::propertyToDTO).collect(Collectors.toList());
    }

    /**
     * Calcula a área de um cômodo
     * @param room Cômodo informado para o cálculo da área
     * @return Área do cômodo informado
     */
    private Double calculateRoomArea(Room room) {
        return room.getRoomLength() * room.getRoomWidth();
    }

    /**
     * Calcula o preço de uma popriedade
     * @param property Propriedade informada para o cálculo do preço
     * @return Preço da propriedade informada
     */
    private BigDecimal calculatePropertyPrice(Property property) {

         return property.getDistrict().getValueDistrictM2().multiply(BigDecimal.valueOf(calculateTotalArea(property.getId()).getTotalArea()));
    }

    /**
     * Calcula a área total de uma propriedade
     * @param id Id da propriedade que terá área total calculada
     * @return Área total da propriedade informada
     */
    public PropertyTotalAreaDTO calculateTotalArea(String id) {
        Property property = propertyRepository.getProperty(id);

        Double totalPropertyArea = property.getRooms().stream()
                .reduce(0.0, (acc, currentRoom) -> acc + calculateRoomArea(currentRoom), Double::sum);

        return new PropertyTotalAreaDTO(id, property.getName(), totalPropertyArea);
    }

    /**
     * Busca pelo maior cômodo de uma propriedade
     * @param propertyId Id da propriedade que terá o maior cômodo buscado
     * @return Maior cômodo da propriedade informada
     */
    public LargestRoomAreaDTO findLargestRoom(String propertyId) {
        Property property = propertyRepository.getProperty(propertyId);

        Room room = property.getRooms().stream().max(Comparator.comparing(this::calculateRoomArea)).orElse(new Room());

        return new LargestRoomAreaDTO(property.getName(), room.getRoomName(), calculateRoomArea(room));
    }

    /**
     * Calcula a área de cada cômodo de uma propriedade
     * @param propertyId Id da propriedade que terá a área dos cômodos calculada
     * @return Áreas dos cômodos da propriedade informada
     */
    public RoomAreasDTO calculateAreaRooms(String propertyId) {
        Property property = propertyRepository.getProperty(propertyId);

        Map<String, Double> roomsMap = new HashMap<>();
        property.getRooms().forEach(room -> roomsMap.put(room.getRoomName(), calculateRoomArea(room)));

        return new RoomAreasDTO(roomsMap);

    }

    /**
     * Calcula o preço de uma popriedade
     * @param propertyId Id da propriedade que terá o preço calculado
     * @return Preço da propriedade informada
     */
    public PropertyPriceDTO calculateProperty(String propertyId) {
        Property property = propertyRepository.getProperty(propertyId);
        return new PropertyPriceDTO(property.getName(), calculatePropertyPrice(property));
    }
}
