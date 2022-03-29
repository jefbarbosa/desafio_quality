package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {
    private String id;
    private String name;
    private DistrictDTO district;
    private List<RoomDTO> rooms;


    public static Property dtoToProperty(PropertyDTO propertyDTO) {
        District district = DistrictDTO.dtoToDistrict(propertyDTO.getDistrict());
        List<Room> roomList = propertyDTO.getRooms().stream().map(RoomDTO::dtoToRoom).collect(Collectors.toList());

        return new Property(UUID.randomUUID().toString(), propertyDTO.getName(), district, roomList);
    }

    public static PropertyDTO propertyToDTO(Property property) {
        DistrictDTO districtDTO = DistrictDTO.districtToDTO(property.getDistrict());
        List<RoomDTO> roomDTOList = property.getRooms().stream().map(RoomDTO::roomToDTO).collect(Collectors.toList());

        return new PropertyDTO(property.getId(), property.getName(), districtDTO, roomDTOList);
    }
}
