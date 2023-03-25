package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.dominio.dto.response.OrdenDeTrabajoResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdenTrabajoMapper {
    OrdenTrabajo mapToEntity(OrdenTrabajoDto dto);

    OrdenDeTrabajoResponseDto mapToDto(OrdenTrabajo orden);
}
