package com.sone.ccvn.api.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vn_comunidade_docs")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComunidadeDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @JoinColumn(name = "document_file_name", nullable = false)
    private String documentFileName;

    @Column(name = "vn_file", nullable = false)
    private String file;

    @ManyToOne
    @JoinColumn(name = "comunidade_id")
    private Comunidade comunidade;
}
