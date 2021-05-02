package com.sone.ccvn.api.dtos.request;

import com.sone.ccvn.api.enums.TelefoneTipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO {

    private Long id;

    private TelefoneTipo tipo;

    private String nome;
}
