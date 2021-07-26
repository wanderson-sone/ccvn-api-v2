package com.sone.ccvn.api.services.mapper;

import com.sone.ccvn.api.services.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.entities.Endereco;
import org.mapstruct.Mapper;


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