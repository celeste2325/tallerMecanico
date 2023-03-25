package com.besysoft.taller_mecanico.repositories;

import com.besysoft.taller_mecanico.dominio.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
