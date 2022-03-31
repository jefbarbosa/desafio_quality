package br.com.meli.desafio_quality.controller;

import br.com.meli.desafio_quality.dto.*;
import br.com.meli.desafio_quality.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  Classe controlador responsável por lidar com as rotas referentes ao recurso property.
 *  Possui rotas para criação, listagem e cálculos relacionados a uma propriedade.
 *
 * @author Jederson Macedo
 * @author Jeferson Barbosa
 */
@RestController
@RequestMapping("/property")
public class PropertyController {

    /**
     * {@link PropertyService Service} de property injetado
     */
    @Autowired
    private PropertyService propertyService;

    /**
     * Endpoint responsável pela criação de uma propriedade
     *
     * @param propertyDTO Propriedade que será cadastrada
     * @return Propriedade criada
     */
    @PostMapping("/insert")
    public ResponseEntity<PropertyDTO> insertProperty(@RequestBody @Valid PropertyDTO propertyDTO) {
        return new ResponseEntity<>(propertyService.insertProperty(propertyDTO), HttpStatus.CREATED);
    }

    /**
     * Endpoint responsável pela listagem de todas as propriedades já cadastradas
     *
     * @return Lista de propriedades
     */
    @GetMapping("/get-all-properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        return new ResponseEntity<>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    /**
     * Endpoint responsável por retornar a área total de uma determinada propriedade
     *
     * @param propertyId Id da propriedade que terá sua área calculada
     * @return id, nome e área total da propriedade informada
     */
    @GetMapping("/calculate-total-area-property/{propertyId}")
    public ResponseEntity<PropertyTotalAreaDTO> calculateTotalArea(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.calculateTotalArea(propertyId), HttpStatus.OK);
    }

    /**
     * Endpoint responsável por retornar o maior cômodo de uma determinada propriedade
     *
     * @param propertyId Id da propriedade que terá seu maior cômodo retornado
     * @return Nome da propriedade, nome e área total do maior cômodo
     */
    @GetMapping("/find-largest-room/{propertyId}")
    public ResponseEntity<LargestRoomAreaDTO> findLargestRoom(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.findLargestRoom(propertyId), HttpStatus.OK);
    }

    /**
     * Endpoint responsável por retornar a lista de cômodos de uma determinada propriedade
     *
     * @param propertyId Id da propriedade que terá seus cômodos retornados
     * @return Lista de cômodos da propriedade informada
     */
    @GetMapping("/calculate-area-rooms/{propertyId}")
    public ResponseEntity<RoomAreasDTO> calculateAreaRooms(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.calculateAreaRooms(propertyId) , HttpStatus.OK);
    }

    /**
     * Endpoint responsável por retornar o preço total de uma determinada propriedade
     *
     * @param propertyId Id da propriedade que terá seu preço total calculado
     * @return Nome da propriedade e seu preço total
     */
    @GetMapping("/calculate-property-price/{propertyId}")
    public ResponseEntity<PropertyPriceDTO> calculatePropertyPrice(@PathVariable String propertyId) {
        return new ResponseEntity<>(propertyService.calculateProperty(propertyId) ,HttpStatus.OK);
    }

}
