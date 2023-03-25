package com.besysoft.taller_mecanico.dominio.dto;

import com.besysoft.taller_mecanico.dominio.entity.Cliente;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class VehiculoDto {
    private Long id;
    private String color;
    private String marca;
    private String modelo;
    @NotEmpty
    @NotNull
    private String patente;
    private Integer anio;
    private List<Cliente> clientesById;
    private List<OrdenTrabajo> ordenesTrabajosById;
}
