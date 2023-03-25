package com.besysoft.taller_mecanico.dominio.dto.response;

import lombok.Data;

@Data
public class VehiculoResponseDto {
    private String color;
    private String marca;
    private String modelo;
    private String patente;
    private Integer anio;
}
