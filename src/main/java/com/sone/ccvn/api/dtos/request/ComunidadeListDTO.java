package com.sone.ccvn.api.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ComunidadeListDTO implements Serializable {

    private Long id;

    private String razaoSocial;

    private String cnpj;

    private String moderador;

}