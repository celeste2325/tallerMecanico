package com.besysoft.taller_mecanico.dominio.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RepuestoDto {
    private Long id;
    private String marca;
    private String modelo;
    private String repuesto;
    private BigDecimal valor;
}
