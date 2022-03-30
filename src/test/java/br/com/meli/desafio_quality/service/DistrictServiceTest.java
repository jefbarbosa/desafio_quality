package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.DistrictDTO;
import br.com.meli.desafio_quality.dto.ErrorDTO;
import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.exception.PropertyException;
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
    private DistrictRespository districtRespository;

    @BeforeEach
    private void initializeProperties() {
        MockitoAnnotations.openMocks(this);
        this.districtService = new DistrictService(districtRespository);
    }

    @Test
    public void getInexistentDistrictServiceTest() {

        Mockito.when(districtRespository.findDistrict("Tijuca")).thenReturn(new District("Tijuca", BigDecimal.valueOf(15000)));
        Mockito.when(districtRespository.findDistrict("District non existent")).thenReturn(
                new ErrorDTO("DistrictAlreadyExists", "This District already exists!")
        );

        DistrictDTO districtDTO = districtService.findDistrict("Tijuca");

        assertEquals("Tijuca", districtDTO.getName());

        try {
            districtService.findDistrict("District non existent");
        } catch(PropertyException ex) {
            System.out.println(ex.getError());
        }

//        assertNotEquals("Tijuca", districtDTO.getName());
    }

    @Test
    public void getDistrictRepositoryTest() {
        // Check if the respository call is working with a pre-defined(startup load) data, property named Tijuca

        try {
            districtService.findDistrict("District non existent");
        } catch(PropertyException ex) {
            System.out.println(ex.getError());
        }

        //assertEquals("Tijuca", district.getName());
    }
}
