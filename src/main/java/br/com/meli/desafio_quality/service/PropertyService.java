package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.LargestRoomAreaDTO;
import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.dto.PropertyTotalAreaDTO;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
import br.com.meli.desafio_quality.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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

    private Double calculateRoomArea(Room room) {
        return room.getRoomLength() * room.getRoomWidth();
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

}
