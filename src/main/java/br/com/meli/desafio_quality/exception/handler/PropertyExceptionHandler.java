package br.com.meli.desafio_quality.exception.handler;

import br.com.meli.desafio_quality.dto.ErrorDTO;
import br.com.meli.desafio_quality.exception.DistrictNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException ex){
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(HttpMessageNotReadableException ex){
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotFoundException(DistrictNotFoundException ex) {
        ErrorDTO error = new ErrorDTO("DistrictNotFoundException", ex.getError().getDescription());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
