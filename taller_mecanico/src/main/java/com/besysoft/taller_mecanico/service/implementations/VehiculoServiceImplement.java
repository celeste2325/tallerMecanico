package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import com.besysoft.taller_mecanico.excepciones.VehiculoExistenteException;
import com.besysoft.taller_mecanico.repositories.VehiculoRepository;
import com.besysoft.taller_mecanico.service.interfaces.VehiculoService;
import org.springframework.stereotype.Service;

@Service
public class VehiculoServiceImplement implements VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImplement(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Vehiculo altaVehiculo(Vehiculo newVehiculo) throws VehiculoExistenteException {
        if (this.vehiculoRepository.findByPatente(newVehiculo.getPatente()) == null) {
            return this.vehiculoRepository.save(newVehiculo);
        } else {
            throw new VehiculoExistenteException("Ya existe el vehiculo");
        }
    }
}
