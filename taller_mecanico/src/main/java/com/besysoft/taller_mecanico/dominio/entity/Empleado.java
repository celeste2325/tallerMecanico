package com.besysoft.taller_mecanico.dominio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String apellido;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    private String nombres;
    private String tipoEmpleado;
    @OneToMany(mappedBy = "empleadosByAdmnistrativoId")
    private Collection<OrdenTrabajo> ordenesTrabajosById;
    @OneToMany(mappedBy = "empleadosByRecepcionistaId")
    private Collection<OrdenTrabajo> ordenesTrabajosById_0;

}
