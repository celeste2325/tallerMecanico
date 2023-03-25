package com.besysoft.taller_mecanico.repositories;

import com.besysoft.taller_mecanico.dominio.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByCorreoElectronico(String correoElectronico);
}
