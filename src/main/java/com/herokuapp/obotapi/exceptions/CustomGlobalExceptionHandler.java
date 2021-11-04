package com.herokuapp.obotapi.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ){
        List<ObjectError> exceptions = ex.getBindingResult().getAllErrors();

        List<String> exceptionMessages = new ArrayList<>();

        for (ObjectError exception: exceptions){
            exceptionMessages.add(exception.getDefaultMessage());
        }

        ObjectMapper objectMapper = new ObjectMapper();

        String errors = "";

        try{
            errors = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(exceptionMessages);
        } catch (JsonProcessingException jpe){
            LOG.error(jpe.getMessage());
        }

        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "from handleMethodArgumentNotValid", errors);

        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request
    ){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "from handleMethodArgumentNotValid", ex.getMessage());

        return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex,
                                                                           WebRequest request){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
                "from handleConstraintViolationException", ex.getMessage());

        return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
    }
}
