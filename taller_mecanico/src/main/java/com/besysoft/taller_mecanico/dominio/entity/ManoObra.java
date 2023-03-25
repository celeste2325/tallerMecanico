package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mano_obra")
public class ManoObra implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String detalle;
    private LocalDateTime duracionHs;
    @ManyToOne
    private Mecanico mecanicosByMecanicoId;
    @ManyToOne(cascade = CascadeType.ALL)
    private OrdenTrabajo ordenesTrabajoByOrdenTrabajoId;

    @Override
    public String toString() {
        return "ManoObra{" +
                "id=" + id +
                ", detalle='" + detalle + '\'' +
                ", duracionHs=" + duracionHs +
                '}';
    }
}
