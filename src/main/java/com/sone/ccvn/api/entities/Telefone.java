package com.sone.ccvn.api.entities;

import com.sone.ccvn.api.enums.TelefoneTipo;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vn_telefone")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "telefone_tipo" , nullable = false)
    private TelefoneTipo tipo;

    @Column(nullable = false)
    private String numero;

    public Telefone(Long id, TelefoneTipo tipo, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
    }
}
