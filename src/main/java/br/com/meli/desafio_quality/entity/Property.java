package br.com.meli.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private String id;
    private String name;
    private District district;
    private List<Room> rooms;
}
