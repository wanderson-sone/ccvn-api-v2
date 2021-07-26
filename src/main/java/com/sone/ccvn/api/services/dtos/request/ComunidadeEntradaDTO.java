package com.sone.ccvn.api.services.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComunidadeEntradaDTO implements Serializable {

    private Long id;

    private String nome;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private String inscEstadual;

    private String email;

    private String dataFundacao;

    private Boolean status;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    private Long localidade_id;

    private List<TelefoneDTO> telefones;
}
