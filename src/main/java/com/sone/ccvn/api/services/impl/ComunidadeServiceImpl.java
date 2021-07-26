package com.sone.ccvn.api.services.impl;

import com.sone.ccvn.api.dtos.mapper.ComunidadeMapper;
import com.sone.ccvn.api.dtos.mapper.EnderecoMapper;
import com.sone.ccvn.api.dtos.mapper.TelefoneMapper;
import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.dtos.request.TelefoneDTO;
import com.sone.ccvn.api.dtos.response.MessageResponseDTO;
import com.sone.ccvn.api.entities.Comunidade;
import com.sone.ccvn.api.entities.Endereco;
import com.sone.ccvn.api.entities.Localidade;
import com.sone.ccvn.api.entities.Telefone;
import com.sone.ccvn.api.repositories.*;
import com.sone.ccvn.api.services.ComunidadeService;
import com.sone.ccvn.api.services.EnderecoService;
import com.sone.ccvn.api.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ComunidadeServiceImpl implements ComunidadeService {

    private final ComunidadeRepository comunidadeRepository;

    private final EnderecoService enderecoService;

    private final ComunidadeMapper comunidadeMapper;


    public List<ComunidadeDTO> findAll() {
        List<Comunidade> allComunidades = comunidadeRepository.findAll();

        allComunidades.stream().map(Comunidade::getEnderecos).collect(Collectors.toList());
        return allComunidades.stream().map(comunidadeMapper::toDto)
                .collect(Collectors.toList());
    }

    public ComunidadeDTO create(ComunidadeDTO obj) {
        Comunidade comunidade = comunidadeMapper.toEntity(obj);
        comunidade.getEnderecos().addAll(enderecoService.persist(obj.getEnderecos()));
        comunidade.getEnderecos().forEach(endereco -> endereco.setComunidade(comunidade));
        return comunidadeMapper.toDto(comunidadeRepository.save(comunidade));
    }

    public ComunidadeDTO findById(Long id) throws ObjectNotFoundException {
        Comunidade comunidade = verifyIfExists(id);
        return comunidadeMapper.toDto(comunidade);
    }

    public MessageResponseDTO updateById(Long id, ComunidadeDTO dto) throws ObjectNotFoundException {
        verifyIfExists(id);
        Comunidade updatedComunidade = comunidadeRepository.save(comunidadeMapper.toEntity(dto));
        return createMessageResponse(updatedComunidade.getId(), "Comunidade atualizada com sucesso!");
    }

    public void delete(Long id) throws ObjectNotFoundException {
        verifyIfExists(id);
        comunidadeRepository.deleteById(id);
    }

    private Comunidade verifyIfExists(long id) throws ObjectNotFoundException {
        return comunidadeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + " Not Found!"));
    }

    private MessageResponseDTO createMessageResponse(Long id, String msg) {
        return MessageResponseDTO.builder().message(msg + id).build();
    }
}


