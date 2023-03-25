package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ordenes_trabajo")
public class OrdenTrabajo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
    @OneToMany(mappedBy = "ordenesTrabajoByOrdenTrabajoId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DetalleOrdenTrabajo> detalleOrdenesTrabajosById;
    @OneToMany(mappedBy = "ordenesTrabajoByOrdenTrabajoId", fetch = FetchType.LAZY)
    private List<ManoObra> manoObrasById;
    @ManyToOne
    private Empleado empleadosByAdmnistrativoId;
    @ManyToOne
    private Empleado empleadosByRecepcionistaId;
    @ManyToOne
    private Vehiculo vehiculosByVehiculoId;

    @Override
    public String toString() {
        return "OrdenTrabajo{" +
                "id=" + id +
                ", cantidadCuotas=" + cantidadCuotas +
                ", detalleFalla='" + detalleFalla + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaFinReparacion=" + fechaFinReparacion +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaPago=" + fechaPago +
                ", formaPago='" + formaPago + '\'' +
                ", importeTotal=" + importeTotal +
                ", kilometraje=" + kilometraje +
                ", nivelCombustible='" + nivelCombustible + '\'' +
                ", tipoTarjeta='" + tipoTarjeta + '\'' +
                '}';
    }
}

