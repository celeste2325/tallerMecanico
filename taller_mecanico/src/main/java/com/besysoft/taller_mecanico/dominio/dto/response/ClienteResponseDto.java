package com.besysoft.taller_mecanico.dominio.dto.response;

import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import lombok.Data;

import java.util.List;

@Data
public class ClienteResponseDto {
    private String nombres;
    private String apellido;
    private String correoElectronico;
    private List<Vehiculo> vehiculos;
}
