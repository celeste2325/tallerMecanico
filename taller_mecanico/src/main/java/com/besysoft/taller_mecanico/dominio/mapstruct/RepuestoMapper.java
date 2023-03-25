package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.RepuestoDto;
import com.besysoft.taller_mecanico.dominio.entity.Repuesto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RepuestoMapper {
    Repuesto mapToEntity(RepuestoDto dto);

    RepuestoDto mapToDto(Repuesto cliente);
}
