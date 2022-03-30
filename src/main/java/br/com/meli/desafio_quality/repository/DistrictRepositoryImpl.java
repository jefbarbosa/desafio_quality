package br.com.meli.desafio_quality.repository;

import br.com.meli.desafio_quality.entity.District;
import br.com.meli.desafio_quality.exception.DistrictNotFoundException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
    private static List<District> districts = new ArrayList<>(Arrays.asList(
            new District("Barra da Tijuca", BigDecimal.valueOf(20.0)),
            new District("Alphaville", BigDecimal.valueOf(10.0))
    ));

    @Override
    public District findDistrict(String districtName) {
        return districts.stream().filter(district -> district.getName().equals(districtName))
                .findFirst()
                .orElseThrow(() -> new DistrictNotFoundException("o bairro " + districtName + " não está cadastrado."));
    }
}
