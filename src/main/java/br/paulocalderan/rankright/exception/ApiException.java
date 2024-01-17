package br.paulocalderan.rankright.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
