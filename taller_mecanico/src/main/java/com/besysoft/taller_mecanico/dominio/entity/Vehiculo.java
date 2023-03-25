package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String color;
    private String marca;
    private String modelo;
    @Column(unique = true)
    private String patente;
    private Integer anio;
    @ManyToMany(mappedBy = "vehiculos", fetch = FetchType.LAZY)
    private List<Cliente> clientesById;
    @OneToMany(mappedBy = "vehiculosByVehiculoId")
    private List<OrdenTrabajo> ordenesTrabajosById;

    @Override
    public String toString() {
        return "Vehiculo{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", patente='" + patente + '\'' +
                ", anio=" + anio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(patente, vehiculo.patente);
    }
}
