package com.sone.ccvn.api.dtos.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ComunidadeDocumentDTO implements Serializable {

    private Integer id;

    private String documentFileName;

    private String file;

    public ComunidadeDocumentDTO(Integer id, String documentFileName, String file) {
        this.id = id;
        this.documentFileName = documentFileName;
        this.file = file;
    }
}
