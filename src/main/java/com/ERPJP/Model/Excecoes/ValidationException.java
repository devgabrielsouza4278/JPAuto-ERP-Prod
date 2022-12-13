package com.ERPJP.Model.Excecoes;

import com.ERPJP.Model.DTO.ValidationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ValidationException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationExceptionResponse handle (MethodArgumentNotValidException exception) {
    ValidationExceptionResponse response = new ValidationExceptionResponse();
    response.setTimestamp(LocalDateTime.now());
    response.setCampo(exception.getBindingResult().getFieldError().getField());
    response.setMensagemDesenvolvedor(exception.getBindingResult().getFieldError().getDefaultMessage());
    response.setStatus(HttpStatus.BAD_REQUEST.value());
    response.setErro(HttpStatus.BAD_REQUEST.getReasonPhrase());
    return response;
    }
}
