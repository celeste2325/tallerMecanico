package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.entity.Repuesto;
import com.besysoft.taller_mecanico.repositories.RepuestoRepository;
import com.besysoft.taller_mecanico.service.interfaces.RepuestoService;
import org.springframework.stereotype.Service;

@Service
public class RepuestoServiceImplement implements RepuestoService {
    private final RepuestoRepository repuestoRepository;

    public RepuestoServiceImplement(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public Repuesto altaRepuesto(Repuesto newRepuesto) {
        return this.repuestoRepository.save(newRepuesto);
    }
}
