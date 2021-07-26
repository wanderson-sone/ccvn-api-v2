package com.sone.ccvn.api.services.mapper;

import com.sone.ccvn.api.services.dtos.request.LocalidadeDTO;
import com.sone.ccvn.api.entities.Localidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses ={
        ComunidadeMapper.class,
        EstadoMapper.class
})
public interface LocalidadeMapper extends EntityMapper<LocalidadeDTO, Localidade> {

    @Mapping(target = "nome", source = "nome")
    LocalidadeDTO toDto(Localidade localidade);
}
