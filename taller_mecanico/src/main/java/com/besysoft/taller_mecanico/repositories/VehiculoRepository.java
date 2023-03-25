package com.besysoft.taller_mecanico.repositories;

import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    Vehiculo findByPatente(String patente);
}
