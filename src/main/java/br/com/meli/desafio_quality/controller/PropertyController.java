package br.com.meli.desafio_quality.controller;

import br.com.meli.desafio_quality.dto.LargestRoomAreaDTO;
import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.dto.PropertyTotalAreaDTO;
import br.com.meli.desafio_quality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/insert")
    public ResponseEntity<PropertyDTO> insertProperty(@RequestBody PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.insertProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @GetMapping("/calculate-total-area-property/{propertyId}")
    public ResponseEntity<PropertyTotalAreaDTO> calculateTotalArea(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.calculateTotalArea(propertyId), HttpStatus.OK);
    }

    @GetMapping("/find-largest-room/{propertyId}")
    public ResponseEntity<LargestRoomAreaDTO> findLargestRoom(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.findLargestRoom(propertyId), HttpStatus.OK);
    }

}
