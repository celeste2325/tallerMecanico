package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "detalle_ordenes_trabajo")
public class DetalleOrdenTrabajo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    private Integer cantidad;
    private BigDecimal valorTotal;
    @ManyToOne()
    private OrdenTrabajo ordenesTrabajoByOrdenTrabajoId;
    @ManyToOne
    private Repuesto repuestosByRepuestoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleOrdenTrabajo that = (DetalleOrdenTrabajo) o;
        return Objects.equals(cantidad, that.cantidad) && Objects.equals(valorTotal, that.valorTotal) && Objects.equals(ordenesTrabajoByOrdenTrabajoId.getId(), that.ordenesTrabajoByOrdenTrabajoId.getId()) && Objects.equals(repuestosByRepuestoId.getId(), that.repuestosByRepuestoId.getId());
    }

    @Override
    public String toString() {
        return "DetalleOrdenTrabajo{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
