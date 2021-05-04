package com.sone.ccvn.api.entities;

import com.sone.ccvn.api.enums.TelefoneTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "vn_telefone")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "telefone_tipo" ,nullable = false)
    private TelefoneTipo tipo;

    @Column(nullable = false, unique = true)
    private String numero;
}
