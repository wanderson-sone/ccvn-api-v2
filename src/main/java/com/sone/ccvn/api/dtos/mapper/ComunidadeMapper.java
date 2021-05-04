package com.sone.ccvn.api.dtos.mapper;

import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.entities.Comunidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ComunidadeMapper {

    ComunidadeMapper INSTANCE = Mappers.getMapper(ComunidadeMapper.class);

    @Mapping(target = "dataFundacao", source = "dataFundacao", dateFormat = "dd-MM-yyyy")
    Comunidade toComunidade(ComunidadeDTO comunidadeDTO);

    ComunidadeDTO comunidadeToComunidadeDTO (Comunidade comunidade);
}
