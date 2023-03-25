package com.besysoft.taller_mecanico.dominio.dto;

import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import lombok.Data;

import java.util.List;

@Data
public class MecanicoDto {
    private Long id;
    private String activo;
    private String apellido;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    private String especialidad;
    private String nombres;
    private List<ManoObra> manoObrasById;
}
