package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.ManoDeObraDto;
import com.besysoft.taller_mecanico.dominio.dto.response.ManoDeObraResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManoDeObraMapper {
    ManoObra mapToEntity(ManoDeObraDto dto);

    ManoDeObraResponseDto mapToDto(ManoObra manoObra);
}
