package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String nombres;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    @Column(unique = true)
    private String correoElectronico;
    private String telefonoLinea;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_vehiculo",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id")
    )
    private List<Vehiculo> vehiculos;

    @Override
    public String toString() {
        return "Cliente{" +
                "apellido='" + apellido + '\'' +
                ", nombres='" + nombres + '\'' +
                ", celular='" + celular + '\'' +
                ", calle='" + calle + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", departamento='" + departamento + '\'' +
                ", localidad='" + localidad + '\'' +
                ", numero='" + numero + '\'' +
                ", piso='" + piso + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefonoLinea='" + telefonoLinea + '\'' +
                '}';
    }
}
