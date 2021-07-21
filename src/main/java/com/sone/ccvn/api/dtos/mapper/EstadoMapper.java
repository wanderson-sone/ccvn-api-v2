package com.sone.ccvn.api.dtos.mapper;

import com.sone.ccvn.api.dtos.request.EstadoDTO;
import com.sone.ccvn.api.entities.Estado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses ={
        ComunidadeMapper.class,
        EnderecoMapper.class,
})
public interface EstadoMapper extends EntityMapper<EstadoDTO, Estado> {
}
