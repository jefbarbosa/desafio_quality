package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {

    @NotBlank(message = "O nome do bairro não pode estar vazio.")
    @Size(max = 45, message = "O comprimento do nome do bairro não pode exceder 45 caracteres.")
    private String name;

    @NotNull(message = "O valor do metro quadrado não pode estar vazio.")
    @Size(max = 13, message = "O comprimento do valor do metro quadrado não pode exceder 13 caracteres.")
    private BigDecimal valueDistrictM2;

    public static District dtoToDistrict(DistrictDTO districtDTO) {
        return new District(districtDTO.getName(), districtDTO.getValueDistrictM2());
    }

    public static DistrictDTO districtToDTO(District district) {
        return new DistrictDTO(district.getName(), district.getValueDistrictM2());
    }
}
