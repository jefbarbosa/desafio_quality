package br.com.meli.desafio_quality.repository;

import br.com.meli.desafio_quality.entity.District;

public interface DistrictRepository {
    District findDistrict(String districtName);
}
