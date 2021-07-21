package com.sone.ccvn.api.dtos.mapper;

import com.sone.ccvn.api.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.entities.Endereco;
import com.sone.ccvn.api.entities.Localidade;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring", uses ={
    LocalidadeMapper.class
})
public interface EnderecoMapper extends EntityMapper<EnderecoDTO, Endereco> {

    @Override
    Endereco toEntity(EnderecoDTO enderecoDTO);

//    @BeforeMapping
//    default void setRelations(EnderecoDTO dto, @MappingTarget Endereco endereco){
//        Localidade localidade = new Localidade();
//        localidade.setId(dto.getLocalidade_id());
//
//        endereco.setLocalidade(localidade);
//    }
}