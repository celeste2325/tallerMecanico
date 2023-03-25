package com.besysoft.taller_mecanico.repositories;

import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManoDeObraRepository extends JpaRepository<ManoObra, Long> {
}
