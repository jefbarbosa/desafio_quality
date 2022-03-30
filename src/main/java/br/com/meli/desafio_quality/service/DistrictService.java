package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.DistrictDTO;
import br.com.meli.desafio_quality.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public DistrictDTO findDistrict(String districtName) {
        return  DistrictDTO.districtToDTO(districtRepository.findDistrict(districtName));
    }
}
