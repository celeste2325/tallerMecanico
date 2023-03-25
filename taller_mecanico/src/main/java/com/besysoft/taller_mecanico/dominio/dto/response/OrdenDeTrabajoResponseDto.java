package com.besysoft.taller_mecanico.dominio.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrdenDeTrabajoResponseDto {
    private Long id;
    private Integer cantidadCuotas;
    private String detalleFalla;
    private String estado;
    private LocalDateTime fechaFinReparacion;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaPago;
    private String formaPago;
    private BigDecimal importeTotal;
    private Long kilometraje;
    private String nivelCombustible;
    private String tipoTarjeta;
}
