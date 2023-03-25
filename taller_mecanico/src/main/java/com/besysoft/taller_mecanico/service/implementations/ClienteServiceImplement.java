package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.entity.Cliente;
import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import com.besysoft.taller_mecanico.excepciones.ClienteExistenteException;
import com.besysoft.taller_mecanico.excepciones.ClienteInexistenteException;
import com.besysoft.taller_mecanico.excepciones.VehiculoInexistenteException;
import com.besysoft.taller_mecanico.repositories.ClienteRepository;
import com.besysoft.taller_mecanico.repositories.VehiculoRepository;
import com.besysoft.taller_mecanico.service.interfaces.ClienteService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteServiceImplement implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;

    public ClienteServiceImplement(ClienteRepository clienteRepository, VehiculoRepository vehiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public Cliente altaCliente(Cliente newCliente) throws ClienteExistenteException {
        if (this.clienteRepository.findByCorreoElectronico(newCliente.getCorreoElectronico()) == null) {
            return this.clienteRepository.save(newCliente);
        }
        throw new ClienteExistenteException("Ya existe el cliente");
    }

    public Cliente vincularVehiculo(Vehiculo vehiculo, Long idCliente) throws ClienteInexistenteException, VehiculoInexistenteException {
        Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);
        if (cliente.isPresent()) {
            if (this.vehiculoRepository.findByPatente(vehiculo.getPatente()) != null) {
                if (!cliente.get().getVehiculos().contains(vehiculo)) {
                    cliente.get().getVehiculos().add(vehiculo);
                    return this.clienteRepository.save(cliente.get());
                }
            }
            throw new VehiculoInexistenteException("El vehiculo no existe, debe crearlo");
        }
        throw new ClienteInexistenteException("El cliente no existe, debe crearlo");

    }

    //el cliente existe
    public Cliente vincularVehiculoCompleto(Vehiculo vehiculo, Long idCliente) {
        Optional<Cliente> byCorreoElectronico = this.clienteRepository.findById(idCliente);

        if (this.vehiculoRepository.findByPatente(vehiculo.getPatente()) == null) {
            this.vehiculoRepository.save(vehiculo);
        } else if (!byCorreoElectronico.get().getVehiculos().contains(vehiculo)) {
            byCorreoElectronico.get().getVehiculos().add(vehiculo);
        }
        return byCorreoElectronico.get();
    }

}
