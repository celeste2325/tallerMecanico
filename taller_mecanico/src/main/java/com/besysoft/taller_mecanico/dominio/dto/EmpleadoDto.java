package com.besysoft.taller_mecanico.dominio.dto;

import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import lombok.Data;

import java.util.Collection;

@Data
public class EmpleadoDto {
    private Long id;
    private String apellido;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    private String nombres;
    private String tipoEmpleado;
    private Collection<OrdenTrabajo> ordenesTrabajosById;
    private Collection<OrdenTrabajo> ordenesTrabajosById_0;
}
