package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomAreasDTO {
    private Map<String, Double> roomAreas;
}
