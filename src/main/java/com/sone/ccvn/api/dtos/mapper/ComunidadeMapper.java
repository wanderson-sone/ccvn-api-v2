package com.sone.ccvn.api.dtos.mapper;

import com.sone.ccvn.api.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.dtos.request.ComunidadeEntradaDTO;
import com.sone.ccvn.api.dtos.request.ComunidadeReportDTO;
import com.sone.ccvn.api.dtos.request.EnderecoDTO;
import com.sone.ccvn.api.entities.Comunidade;
import com.sone.ccvn.api.entities.Endereco;
import com.sone.ccvn.api.entities.Localidade;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        EnderecoMapper.class,
        TelefoneMapper.class,
        LocalidadeMapper.class,
        EstadoMapper.class
})
public interface ComunidadeMapper extends EntityMapper<ComunidadeDTO, Comunidade> {

    @Mapping(target = "moderador", source = "moderador")
    @Mapping(target = "fundador", source = "fundador")
    @Mapping(target = "razaoSocial", source = "razaoSocial")
    ComunidadeDTO toDto (Comunidade comunidade);

    List<ComunidadeReportDTO> toListDto(List<ComunidadeDTO> comunidadeDTO);
}
