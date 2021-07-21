package com.sone.ccvn.api.dtos.request;

import com.sone.ccvn.api.entities.Estado;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class LocalidadeDTO implements Serializable {

    private Long id;

    private String nome;

    private Estado estado;
}
