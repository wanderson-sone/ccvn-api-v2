package com.sone.ccvn.api.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) { super(msg); }

    public ObjectNotFoundException(String msg, Throwable cause) { super(msg, cause); }
}