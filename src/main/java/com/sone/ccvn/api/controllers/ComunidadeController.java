package com.sone.ccvn.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/community")
public class ComunidadeController {

    @RequestMapping
    public String getComunidade(){
        return "Comunidade rest funcionando!...";
    }
}
