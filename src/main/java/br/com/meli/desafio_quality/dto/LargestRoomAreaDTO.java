package br.com.meli.desafio_quality.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LargestRoomAreaDTO {
    private String propertyName;
    private String roomName;
    private Double totalArea;
}
