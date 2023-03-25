package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import com.besysoft.taller_mecanico.excepciones.VehiculoExistenteException;

public interface VehiculoService {
    Vehiculo altaVehiculo(Vehiculo newVehiculo) throws VehiculoExistenteException;
}
