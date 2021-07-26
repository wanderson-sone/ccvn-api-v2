package com.sone.ccvn.api.services;

import com.sone.ccvn.api.services.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.entities.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> persist(List<EnderecoDTO> listDto);
}
