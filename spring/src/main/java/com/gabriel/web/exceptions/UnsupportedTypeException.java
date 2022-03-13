package com.gabriel.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnsupportedTypeException extends RuntimeException {
    public UnsupportedTypeException(String mes) {
        super(mes);
    }
}
