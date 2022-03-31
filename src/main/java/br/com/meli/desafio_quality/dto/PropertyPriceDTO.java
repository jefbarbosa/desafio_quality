package br.com.meli.desafio_quality.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class PropertyPriceDTO {
    private String name;
    private BigDecimal price;
}
