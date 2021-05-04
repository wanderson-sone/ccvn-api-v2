package com.sone.ccvn.api.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vn_comunidade")
@Data
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
    private String noRazaoSocial;

    @NotNull
    @Column(name = "cnpj")
    private String cnpj;

    @NotNull
    @Column(name = "insc_estadual")
    private String inscEstadual;

    @Column(name = "email")
    private String email;

    @Column(name = "data_fundacao")
    private LocalDate dataFundacao;

    private Boolean status;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Membro> membros = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "comunidade", fetch = FetchType.LAZY)
    private List<Endereco> Enderecos = new ArrayList<>();

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
