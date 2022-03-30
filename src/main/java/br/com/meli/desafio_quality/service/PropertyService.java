package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.*;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
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

@Service
@AllArgsConstructor
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public PropertyDTO insertProperty(PropertyDTO propertyDTO) {
        return PropertyDTO.propertyToDTO(propertyRepository.addProperty(PropertyDTO.dtoToProperty(propertyDTO)));
    }

    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.getAllProperties().stream().map(PropertyDTO::propertyToDTO).collect(Collectors.toList());
    }

    private Double calculateRoomArea(Room room) {
        return room.getRoomLength() * room.getRoomWidth();
    }

    private BigDecimal calculatePropertyPrice(Property property) {

         return property.getDistrict().getValueDistrictM2().multiply(BigDecimal.valueOf(calculateTotalArea(property.getId()).getTotalArea()));
    }

    public PropertyTotalAreaDTO calculateTotalArea(String id) {
        Property property = propertyRepository.getProperty(id);

        Double totalPropertyArea = property.getRooms().stream()
                .reduce(0.0, (acc, currentRoom) -> acc + calculateRoomArea(currentRoom), Double::sum);

        return new PropertyTotalAreaDTO(id, property.getName(), totalPropertyArea);
    }

    public LargestRoomAreaDTO findLargestRoom(String propertyId) {
        Property property = propertyRepository.getProperty(propertyId);

        Room room = property.getRooms().stream().max(Comparator.comparing(this::calculateRoomArea)).orElse(new Room());

        return new LargestRoomAreaDTO(property.getName(), room.getRoomName(), calculateRoomArea(room));
    }

    public RoomAreasDTO calculateAreaRooms(String propertyId) {
        Property property = propertyRepository.getProperty(propertyId);

        Map<String, Double> roomsMap = new HashMap<>();
        property.getRooms().forEach(room -> roomsMap.put(room.getRoomName(), calculateRoomArea(room)));

        return new RoomAreasDTO(roomsMap);

    }

    public PropertyPriceDTO calculateProperty(String propertyId) {
        Property property = propertyRepository.getProperty(propertyId);
        return new PropertyPriceDTO(property.getName(), calculatePropertyPrice(property));
    }
}