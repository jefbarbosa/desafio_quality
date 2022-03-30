package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {


    private String id;

    @NotBlank(message = "O nome da propriedade não pode estar vazio.")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ A-Z0-9]+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome da propriedade não pode exceder 30 caracteres.")
    private String name;

    private DistrictDTO district;
    private List<@Valid RoomDTO> rooms;



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
