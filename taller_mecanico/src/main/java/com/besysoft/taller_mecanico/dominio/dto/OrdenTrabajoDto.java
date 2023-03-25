package com.besysoft.taller_mecanico.dominio.dto;

import com.besysoft.taller_mecanico.dominio.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.Empleado;
import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrdenTrabajoDto {
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
    private List<DetalleOrdenTrabajo> detalleOrdenesTrabajosById;
    private List<ManoObra> manoObrasById;
    private Empleado empleadosByAdmnistrativoId;
    private Empleado empleadosByRecepcionistaId;
    private Vehiculo vehiculosByVehiculoId;
}
