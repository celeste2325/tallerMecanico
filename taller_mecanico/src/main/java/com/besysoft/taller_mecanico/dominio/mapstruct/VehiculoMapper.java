package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.VehiculoDto;
import com.besysoft.taller_mecanico.dominio.dto.response.VehiculoResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehiculoMapper {
    Vehiculo mapToEntity(VehiculoDto dto);

    VehiculoResponseDto mapToDto(Vehiculo vehiculo);
}
