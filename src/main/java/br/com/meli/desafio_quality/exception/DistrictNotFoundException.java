package br.com.meli.desafio_quality.exception;

import br.com.meli.desafio_quality.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DistrictNotFoundException extends RuntimeException {
    private final ErrorDTO error;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public DistrictNotFoundException(String message) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
    }
}
