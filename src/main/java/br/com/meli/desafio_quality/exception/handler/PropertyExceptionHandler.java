package br.com.meli.desafio_quality.exception.handler;

import br.com.meli.desafio_quality.dto.ErrorDTO;
import br.com.meli.desafio_quality.exception.DistrictNotFoundException;
import br.com.meli.desafio_quality.exception.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe ExceptionHandler responsável por lidar com as exceções
 *
 * @author Igor Nogueira
 * @author Arthur Guedes
 */
@RestControllerAdvice
public class PropertyExceptionHandler {

    /**
     * Exceção responsável por tratar dos casos de id inexistente requisitado
     *
     * @param ex    Exceção a ser lançada
     * @return      ResponseEntity com status code
     */
    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlePropertyNotFoundException(PropertyNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }

    /**
     * Exceção responsável por tratar dos casos de argumentos informados inválidos nas requisições
     *
     * @param ex    Exceção a ser lançada
     * @return      ResponseEntity com status code
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException ex){
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exceção responsável por tratar dos casos de formato de mensagem inválido nas requisições
     *
     * @param ex    Exceção a ser lançada
     * @return      ResponseEntity com status code
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(HttpMessageNotReadableException ex){
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /**
     * Exceção responsável por tratar casos onde o bairro informado na requisição não existe
     *
     * @param ex    Exceção a ser lançada
     * @return      ResponseEntity com status code
     */
    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotFoundException(DistrictNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(), ex.getStatus());
    }
}
