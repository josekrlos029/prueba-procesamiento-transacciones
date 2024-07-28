package com.sofka.sofkatransactionservice.application.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.transform.TransformerException;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerRest {
    Logger logger = LoggerFactory.getLogger(ExceptionHandlerRest.class.getName());

    @ExceptionHandler({
            TransformerException.class}
    )
    public ResponseEntity<Object> handlerTransactionException(RuntimeException ex) {
        logger.error("transaction error request: ", ex);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("message", ex.getMessage()));
    }


}
