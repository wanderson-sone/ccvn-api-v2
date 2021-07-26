package com.sone.ccvn.api.services.impl;

import com.sone.ccvn.api.services.mapper.EnderecoMapper;
import com.sone.ccvn.api.services.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.entities.Endereco;
import com.sone.ccvn.api.entities.Localidade;
import com.sone.ccvn.api.repositories.EnderecoRepository;
import com.sone.ccvn.api.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoMapper enderecoMapper;
    
    private final EnderecoRepository enderecoRepository;
    
    @Override
    public List<Endereco> persist(List<EnderecoDTO> listDto) {
        List<Endereco> list = new ArrayList<>();
        listDto.stream().filter(endereco -> endereco.getId() != null).collect(Collectors.toList());
        for(EnderecoDTO enderecoDTO : listDto){
            Localidade localidade = new Localidade();
            localidade.setId(enderecoDTO.getLocalidade_id());
            Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
            endereco.setLocalidade(localidade);
            list.add(endereco);
            enderecoRepository.saveAll(list);
        }
        return list;
    }
}
