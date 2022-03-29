package br.com.meli.desafio_quality.dto;

import br.com.meli.desafio_quality.entity.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDTO {
    private String name;
    private BigDecimal valueDistrictM2;

    public static District dtoToDistrict(DistrictDTO districtDTO) {
        return new District(districtDTO.getName(), districtDTO.getValueDistrictM2());
    }

    public static DistrictDTO districtToDTO(District district) {
        return new DistrictDTO(district.getName(), district.getValueDistrictM2());
    }
}
