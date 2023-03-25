package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "repuestos")
public class Repuesto implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String marca;
    private String modelo;
    private String repuesto;
    private BigDecimal valor;
    @OneToMany(mappedBy = "repuestosByRepuestoId")
    private List<DetalleOrdenTrabajo> detalleOrdenesTrabajosById;

}
