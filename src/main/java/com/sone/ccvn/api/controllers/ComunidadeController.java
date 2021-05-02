package com.sone.ccvn.api.controllers;

import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.services.ComunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/community")
public class ComunidadeController {

    private ComunidadeService service;

    @Autowired
    public ComunidadeController(ComunidadeService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createComunidade(@RequestBody @Valid ComunidadeDTO comunidadeDTO) {
        return service.createComunidade(comunidadeDTO);
    }
}
