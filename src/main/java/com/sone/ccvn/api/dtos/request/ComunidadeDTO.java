package com.sone.ccvn.api.dtos.request;

import com.sone.ccvn.api.entities.ComunidadeDocument;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ComunidadeDTO implements Serializable {

    private Long id;

    private String nome;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private String inscEstadual;

    private String email;

    private String dataFundacao;

    private String moderador;

    private String fundador;

    private Boolean status;

    private List<EnderecoDTO> enderecos;

    private List<TelefoneDTO> telefones;

    private List<ComunidadeDocument> documents;
}