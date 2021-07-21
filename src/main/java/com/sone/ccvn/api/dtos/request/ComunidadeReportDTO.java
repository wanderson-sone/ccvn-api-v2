package com.sone.ccvn.api.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ComunidadeReportDTO implements Serializable {

    private String nomeFantasia;

    private String cnpj;

    private String email;

    private String fundador;
}