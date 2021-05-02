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

    private String razaoSocial;

    private String cnpj;

    private List<TelefoneDTO> telefones;
}
