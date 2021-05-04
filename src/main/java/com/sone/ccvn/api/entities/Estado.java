package com.sone.ccvn.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vn_estado")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    private List<Localidade> localidade = new ArrayList<>();

    public Estado(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
