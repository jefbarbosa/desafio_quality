package br.com.meli.desafio_quality.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private String roomName;
    private double roomWidth;
    private double roomLength;

}
