package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.dominio.entity.Empleado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    Empleado mapToEntity(EmpleadoDto dto);

    EmpleadoDto mapToDto(Empleado cliente);
}
