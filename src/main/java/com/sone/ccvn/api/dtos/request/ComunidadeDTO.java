package com.sone.ccvn.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComunidadeDTO {

    private Long id;

    private String nome;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private String inscEstadual;

    private String email;

    private String dataFundacao;

    private Boolean status;

    private List<TelefoneDTO> telefones;
}
