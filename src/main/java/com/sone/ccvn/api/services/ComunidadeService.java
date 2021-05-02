package com.sone.ccvn.api.services;

import com.sone.ccvn.api.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.entities.Comunidade;
import com.sone.ccvn.api.repositories.ComunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunidadeService {

    private ComunidadeRepository repo;

    @Autowired
    public ComunidadeService(ComunidadeRepository repo) {
        this.repo = repo;
    }

    public MessageResponseDTO createComunidade(Comunidade comunidade) {
        Comunidade savedComunidade = repo.save(comunidade);
        return MessageResponseDTO
                .builder()
                .message("Created Comunidade with ID " + savedComunidade.getId())
                .build();
    }
}
