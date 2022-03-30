package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {

    @NotBlank(message = "O nome do cômodo não pode estar vazio.")
    @Pattern(regexp = "[A-Z][a-záàâãéèêíïóôõöúçñ A-Z0-9]+", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    @Size(max = 30, message = "O comprimento do nome do cômodo não pode exceder 30 caracteres.")
    private String roomName;

    @NotNull(message = "A largura do cômodo não pode estar vazia.")
    @DecimalMax(value = "25.0", message = "A largura máxima permitida por cômodo é de 25 metros.")
    private double roomWidth;

    @NotNull(message = "A altura do cômodo não pode estar vazia.")
    @DecimalMax(value = "33.0", message = "A altura máxima permitida por cômodo é de 33 metros.")
    private double roomLength;

    public static Room dtoToRoom(RoomDTO roomDTO) {
        return new Room(roomDTO.getRoomName(), roomDTO.getRoomWidth(), roomDTO.getRoomLength());
    }

    public static RoomDTO roomToDTO(Room room) {
        return new RoomDTO(room.getRoomName(), room.getRoomWidth(), room.getRoomLength());
    }
}
