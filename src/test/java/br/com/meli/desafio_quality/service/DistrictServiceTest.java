package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.DistrictDTO;
import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.exception.DistrictNotFoundException;
import br.com.meli.desafio_quality.repository.DistrictRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *  Classe responsável por testar os métodos do service DistrictService
 *
 * @author Luís Felipe Olimpio
 * @author Lucas Troleiz
 */
public class DistrictServiceTest {


    /**
     * {@link DistrictService Service} serviço que está sendo testado
     */
    private DistrictService districtService;

    /**
     * {@link DistrictRepository Repository} repositório que está sendo mockado
     */
    @Mock
    private DistrictRepository districtRespository;

    /**
     * Instanciando sut
     */
    @BeforeEach
    private void initializeProperties() {
        MockitoAnnotations.openMocks(this);
        this.districtService = new DistrictService(districtRespository);
    }

    /**
     * Teste com objetivo de validar se ao enviar o nome de um bairro como parâmetro, o método findDistrict retorna o bairro procurado
     */
    @Test
    public void getDistrictServiceTest() {
        Mockito.when(districtRespository.findDistrict("Tijuca")).thenReturn(new District("Tijuca", BigDecimal.valueOf(15000)));

        DistrictDTO districtDTO = districtService.findDistrict("Tijuca");

        assertEquals("Tijuca", districtDTO.getName());
    }

    /**
     * Teste com objetivo de validar o erro lançado ao enviar o nome de um bairro não existente como parâmetro do método findDistrict
     */
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
