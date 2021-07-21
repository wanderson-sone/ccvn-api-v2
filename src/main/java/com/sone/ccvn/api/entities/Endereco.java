package com.sone.ccvn.api.entities;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "vn_endereco")
@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "comunidade_id")
    private Comunidade comunidade;

    public Endereco(Long id, String cep, String logradouro, String numero, String complemento, String bairro, Localidade localidade, Comunidade comunidade) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.setLocalidade(localidade);
        this.comunidade = comunidade;
    }

}
