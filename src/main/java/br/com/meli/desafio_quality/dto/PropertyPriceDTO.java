package br.com.meli.desafio_quality.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PropertyPriceDTO {
    private String name;
    private BigDecimal price;
}
