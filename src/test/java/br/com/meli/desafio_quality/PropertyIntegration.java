package br.com.meli.desafio_quality;

import br.com.meli.desafio_quality.dto.DistrictDTO;
import br.com.meli.desafio_quality.dto.PropertyDTO;
import br.com.meli.desafio_quality.dto.RoomDTO;
import br.com.meli.desafio_quality.entity.Property;
import br.com.meli.desafio_quality.entity.Room;
import br.com.meli.desafio_quality.repository.PropertyRepository;
import br.com.meli.desafio_quality.service.PropertyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class PropertyIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    public void insertPropertyAndReturnDtoTest() throws Exception {
        DistrictDTO districtDTO = new DistrictDTO("Tijuca", BigDecimal.valueOf(15000));
        List<RoomDTO> roomsDTO = Arrays.asList(new RoomDTO("kitchen", 10.0, 5.0),
                new RoomDTO("living room", 20.0, 5.0));

        PropertyDTO propertyDTO = new PropertyDTO(null, "Tijuca Village", districtDTO, roomsDTO);

        MvcResult postResult = mockMvc.perform(post("/property/insert")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(propertyDTO)))
                .andExpect(status().isCreated())
                .andReturn();

        String response = postResult.getResponse().getContentAsString();
        PropertyDTO propertyDtoResponse = objectMapper.readValue(response, PropertyDTO.class);

        assertEquals("Tijuca Village", propertyDtoResponse.getName());

        Property property = propertyRepository.getProperty(propertyDtoResponse.getId());
        assertEquals("Tijuca Village", property.getName());
    }


}
