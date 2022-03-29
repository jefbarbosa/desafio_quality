package br.com.meli.desafio_quality.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyTotalAreaDTO {
    private String id;
    private String name;
    private Double totalArea;
}
