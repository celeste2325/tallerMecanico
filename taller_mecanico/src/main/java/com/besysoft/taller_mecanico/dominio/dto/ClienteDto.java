package com.besysoft.taller_mecanico.dominio.dto;

import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ClienteDto {
    private Long id;
    @NotNull
    @NotEmpty
    private String apellido;
    @NotNull
    @NotEmpty
    private String nombres;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    @NotNull
    @NotEmpty
    private String correoElectronico;
    private String telefonoLinea;
    private List<Vehiculo> vehiculos;
}
