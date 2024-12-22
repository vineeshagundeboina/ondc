package com.splenta.hrms.exception;

import org.springframework.http.HttpStatus;



public class UnProcessableException extends RuntimeException {
    public UnProcessableException(String message) {
        super(message);
    }



   public UnProcessableException(String message, Throwable throwable) {
        super(message, throwable);
    }



   public HttpStatus getHttpStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
