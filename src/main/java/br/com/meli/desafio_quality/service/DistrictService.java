package br.com.meli.desafio_quality.service;

import br.com.meli.desafio_quality.dto.DistrictDTO;
import br.com.meli.desafio_quality.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe Service responsável pelos serviços do District. Possui método para encontrar um distrito
 * pelo nome.
 *
 * @author Luis Felipe Olimpio
 */
@Service
@AllArgsConstructor
public class DistrictService {

    /**
     * {@link DistrictRepository Repository} de district injetado
     */
    @Autowired
    private DistrictRepository districtRepository;

    /**
     * Busca por um distrito utilizando o nome como identificador
     *
     * @param districtName  Nome informado para encontrar um distrito
     * @return              Retorna o distrito encontrado ou um objeto District vazio se o cômodo com o nome correspondente não for encontrado
     */
    public DistrictDTO findDistrict(String districtName) {
        return  DistrictDTO.districtToDTO(districtRepository.findDistrict(districtName));
    }
}
