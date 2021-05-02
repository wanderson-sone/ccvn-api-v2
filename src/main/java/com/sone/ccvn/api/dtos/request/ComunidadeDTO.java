package com.sone.ccvn.api.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComunidadeDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @Size(min = 2, max = 100)
    private String razaoSocial;

    @NotEmpty
    @CNPJ
    private String cnpj;

    @Valid
    @NotEmpty
    private List<TelefoneDTO> telefones;
}
