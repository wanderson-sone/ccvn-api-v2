package com.sone.ccvn.api.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vn_comunidade")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @NotNull
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotNull
    @Column(name = "cnpj")
    private String cnpj;

    @NotNull
    @Column(name = "insc_estadual")
    private String inscEstadual;

    @Column(name = "email")
    private String email;

    @Column(name = "data_fundacao")
    private Date dataFundacao;

    @Column(name = "moderador")
    private String moderador;

    @Column(name = "fundador")
    private String fundador;

    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy="comunidade", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();

    @OneToMany(mappedBy = "comunidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComunidadeDocument> documents = new ArrayList<>();

    @Column(name = "created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }

    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        createdAt = atual;
        updatedAt = atual;
    }
}
