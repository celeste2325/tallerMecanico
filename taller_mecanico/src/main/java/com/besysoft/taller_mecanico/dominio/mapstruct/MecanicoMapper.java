package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.MecanicoDto;
import com.besysoft.taller_mecanico.dominio.entity.Mecanico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MecanicoMapper {
    Mecanico mapToEntity(MecanicoDto dto);

    MecanicoDto mapToDto(Mecanico mecanico);
}
