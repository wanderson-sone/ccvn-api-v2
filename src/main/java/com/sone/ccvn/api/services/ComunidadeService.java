package com.sone.ccvn.api.services;

import com.sone.ccvn.api.dtos.mapper.ComunidadeMapper;
import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.entities.Comunidade;
import com.sone.ccvn.api.repositories.ComunidadeRepository;
import com.sone.ccvn.api.services.exception.ComunidadeNoFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunidadeService {

    private final ComunidadeRepository repo;

    private final ComunidadeMapper mapper = ComunidadeMapper.INSTANCE;

    @Autowired
    public ComunidadeService(ComunidadeRepository repo) {
        this.repo = repo;
    }

    public List<ComunidadeDTO> findAll() {
        List<Comunidade> allComunidades = repo.findAll();
        return allComunidades.stream()
                .map(mapper::comunidadeToComunidadeDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO createComunidade(ComunidadeDTO obj) {
        Comunidade savedCommunidate = repo.save(mapper.toComunidade(obj));
        return createMessageResponse(savedCommunidate.getId(), "Comunidade criada com sucesso! ID: ");
    }

    public ComunidadeDTO findById(Long id) throws ComunidadeNoFoundException {
        Comunidade comunidade = verifyIfExists(id);
        return mapper.comunidadeToComunidadeDTO(comunidade);
    }

    public MessageResponseDTO updateById(Long id, ComunidadeDTO comunidadeDTO) throws ComunidadeNoFoundException {
        verifyIfExists(id);
        Comunidade updatedComunidade = repo.save(mapper.toComunidade(comunidadeDTO));
        return createMessageResponse(updatedComunidade.getId(), "Comunidade atualizada com sucesso!");
    }

    public void delete(Long id) throws ComunidadeNoFoundException {
        verifyIfExists(id);
        repo.deleteById(id);
    }

    private Comunidade verifyIfExists(long id) throws ComunidadeNoFoundException {
        return repo.findById(id)
                .orElseThrow(() -> new ComunidadeNoFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String msg){
        return MessageResponseDTO.builder().message(msg + id).build();
    }
}
