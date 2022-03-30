package br.com.meli.desafio_quality.controller;

import br.com.meli.desafio_quality.dto.*;
import br.com.meli.desafio_quality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/insert")
    public ResponseEntity<PropertyDTO> insertProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
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

    @GetMapping("/calculate-area-rooms/{propertyId}")
    public ResponseEntity<RoomAreasDTO> calculateAreaRooms(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.calculateAreaRooms(propertyId) , HttpStatus.OK);
    }

    @GetMapping("/calculate-property-price/{propertyId}")
    public ResponseEntity<PropertyPriceDTO> calculatePropertyPrice(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.calculateProperty(propertyId) ,HttpStatus.OK);
    }

}
