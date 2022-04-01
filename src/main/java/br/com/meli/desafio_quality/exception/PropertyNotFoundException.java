package br.com.meli.desafio_quality.exception;

import br.com.meli.desafio_quality.dto.ErrorDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PropertyNotFoundException extends RuntimeException {
    private final ErrorDTO error;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public PropertyNotFoundException(String propertyId) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), "o ID: " + propertyId + " não está cadastrado.");
    }
}
