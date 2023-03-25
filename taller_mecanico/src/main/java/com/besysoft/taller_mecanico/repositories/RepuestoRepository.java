package com.besysoft.taller_mecanico.repositories;

import com.besysoft.taller_mecanico.dominio.entity.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepuestoRepository extends JpaRepository<Repuesto, Long> {
}
