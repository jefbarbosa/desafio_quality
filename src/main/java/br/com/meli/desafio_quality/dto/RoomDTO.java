package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
    private String roomName;
    private double roomWidth;
    private double roomLength;

    public static Room dtoToRoom(RoomDTO roomDTO) {
        return new Room(roomDTO.getRoomName(), roomDTO.getRoomWidth(), roomDTO.getRoomLength());
    }

    public static RoomDTO roomToDTO(Room room) {
        return new RoomDTO(room.getRoomName(), room.getRoomWidth(), room.getRoomLength());
    }
}
