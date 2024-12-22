package com.splenta.hrms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecordNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public RecordNotFoundException(final String message) {
        super(message);
    }

    public RecordNotFoundException(final Throwable cause) {
        super(cause);
    }
}