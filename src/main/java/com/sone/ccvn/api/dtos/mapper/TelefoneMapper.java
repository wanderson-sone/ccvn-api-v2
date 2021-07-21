package com.sone.ccvn.api.dtos.mapper;

import com.sone.ccvn.api.dtos.request.TelefoneDTO;
import com.sone.ccvn.api.entities.Telefone;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TelefoneMapper extends EntityMapper<TelefoneDTO, Telefone> {
}
