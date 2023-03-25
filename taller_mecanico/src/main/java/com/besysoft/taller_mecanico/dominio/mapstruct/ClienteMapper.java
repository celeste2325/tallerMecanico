package com.besysoft.taller_mecanico.dominio.mapstruct;

import com.besysoft.taller_mecanico.dominio.dto.ClienteDto;
import com.besysoft.taller_mecanico.dominio.dto.response.ClienteResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    Cliente mapToEntity(ClienteDto dto);

    ClienteResponseDto mapToDto(Cliente cliente);
}
