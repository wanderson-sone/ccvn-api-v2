package com.sone.ccvn.api.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ComunidadeNoFoundException extends Exception {
    public ComunidadeNoFoundException(Long id) {
        super("Comunidade não encontrada com o ID: " + id);
    }
}
