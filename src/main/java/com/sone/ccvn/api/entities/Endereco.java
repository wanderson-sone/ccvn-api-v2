package com.sone.ccvn.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vn_endereco")
@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "localidade_id")
    private Localidade localidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "comunidade_id")
    private Comunidade comunidade;
}
