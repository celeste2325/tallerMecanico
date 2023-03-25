package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.dominio.entity.Cliente;
import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import com.besysoft.taller_mecanico.excepciones.ClienteExistenteException;
import com.besysoft.taller_mecanico.excepciones.ClienteInexistenteException;
import com.besysoft.taller_mecanico.excepciones.VehiculoInexistenteException;

public interface ClienteService {
    Cliente altaCliente(Cliente newCliente) throws ClienteExistenteException;

    Cliente vincularVehiculo(Vehiculo vehiculo, Long idCliente) throws ClienteInexistenteException, VehiculoInexistenteException;
}
