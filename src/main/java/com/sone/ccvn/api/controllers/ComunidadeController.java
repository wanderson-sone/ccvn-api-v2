package com.sone.ccvn.api.controllers;

import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.services.ComunidadeService;
import com.sone.ccvn.api.services.exception.ComunidadeNoFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/community")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ComunidadeController {

    private final ComunidadeService service;

    @GetMapping
    public List<ComunidadeDTO> listAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ComunidadeDTO findById(@PathVariable Long id) throws ComunidadeNoFoundException {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createComunidade(@RequestBody ComunidadeDTO obj) {
        return service.createComunidade(obj);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updated(@PathVariable Long id, @RequestBody @Valid ComunidadeDTO obj) throws ComunidadeNoFoundException {
        return service.updateById(id, obj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ComunidadeNoFoundException {
        service.delete(id);
    }
}
