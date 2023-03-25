package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.entity.Mecanico;
import com.besysoft.taller_mecanico.repositories.MecanicoRepository;
import com.besysoft.taller_mecanico.service.interfaces.MecanicoService;
import org.springframework.stereotype.Service;

@Service
public class MecanicoServiceImplement implements MecanicoService {
    private final MecanicoRepository mecanicoRepository;

    public MecanicoServiceImplement(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    public Mecanico altaMecanico(Mecanico mecanico) {
        return this.mecanicoRepository.save(mecanico);
    }
}
