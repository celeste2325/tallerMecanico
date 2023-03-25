package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.entity.Empleado;
import com.besysoft.taller_mecanico.repositories.EmpleadoRepository;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImplement implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImplement(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado altaEmpleado(Empleado newEmpleado) {
        return this.empleadoRepository.save(newEmpleado);
    }
}
