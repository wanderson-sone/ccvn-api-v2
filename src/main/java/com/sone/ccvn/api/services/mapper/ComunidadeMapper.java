package com.sone.ccvn.api.services.mapper;

import com.sone.ccvn.api.services.dtos.request.ComunidadeDTO;
import com.sone.ccvn.api.services.dtos.request.ComunidadeReportDTO;
import com.sone.ccvn.api.entities.Comunidade;
import org.mapstruct.*;

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
