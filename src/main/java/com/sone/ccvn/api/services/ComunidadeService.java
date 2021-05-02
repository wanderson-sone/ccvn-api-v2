package com.sone.ccvn.api.services;

import com.sone.ccvn.api.dtos.mapper.ComunidadeMapper;
import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.entities.Comunidade;
import com.sone.ccvn.api.repositories.ComunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunidadeService {

    private ComunidadeRepository repo;

    private  final ComunidadeMapper mapper = ComunidadeMapper.INSTANCE;

    @Autowired
    public ComunidadeService(ComunidadeRepository repo) {
        this.repo = repo;
    }

    public MessageResponseDTO createComunidade(ComunidadeDTO comunidadeDTO) {
        Comunidade comunidadeToSave = mapper.toComunidade(comunidadeDTO);
        Comunidade savedComunidade = repo.save(comunidadeToSave);
        return MessageResponseDTO
                .builder()
                .message("Created Comunidade with ID " + savedComunidade.getId())
                .build();
    }
}
