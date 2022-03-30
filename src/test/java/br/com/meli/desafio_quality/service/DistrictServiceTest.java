package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.DistrictDTO;
import br.com.meli.desafio_quality.dto.ErrorDTO;
import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.exception.DistrictNotFoundException;
import br.com.meli.desafio_quality.exception.PropertyException;
import br.com.meli.desafio_quality.repository.DistrictRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DistrictServiceTest {

    private DistrictService districtService;

    @Mock
    private DistrictRepository districtRespository;

    @BeforeEach
    private void initializeProperties() {
        MockitoAnnotations.openMocks(this);
        this.districtService = new DistrictService(districtRespository);
    }

    @Test
    public void getDistrictServiceTest() {
        Mockito.when(districtRespository.findDistrict("Tijuca")).thenReturn(new District("Tijuca", BigDecimal.valueOf(15000)));

        DistrictDTO districtDTO = districtService.findDistrict("Tijuca");

        assertEquals("Tijuca", districtDTO.getName());
    }

    @Test
    public void getInexistentDistrictServiceTest() {
        Mockito.when(districtRespository.findDistrict("District non existent")).thenThrow(new DistrictNotFoundException("District non existent"));

        try {
            districtService.findDistrict("District non existent");
        } catch(DistrictNotFoundException ex) {
            System.out.println(ex.getError());
            assertEquals("o bairro District non existent não está cadastrado.", ex.getError().getDescription());
        }
    }
}
