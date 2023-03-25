package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.ClienteDto;
import com.besysoft.taller_mecanico.dominio.dto.VehiculoDto;
import com.besysoft.taller_mecanico.dominio.dto.response.ClienteResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.Cliente;
import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import com.besysoft.taller_mecanico.dominio.mapstruct.ClienteMapper;
import com.besysoft.taller_mecanico.dominio.mapstruct.VehiculoMapper;
import com.besysoft.taller_mecanico.excepciones.ClienteExistenteException;
import com.besysoft.taller_mecanico.excepciones.ClienteInexistenteException;
import com.besysoft.taller_mecanico.excepciones.VehiculoInexistenteException;
import com.besysoft.taller_mecanico.service.interfaces.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@Api(value = "Cliente controller", tags = "Acciones permitidas para la entidad Cliente")
public class ClienteController {
    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;
    private final VehiculoMapper vehiculoMapper;

    @PostMapping()
    @ApiOperation(value = "Permite dar de alta un cliente")
    public ResponseEntity<ClienteResponseDto> altaCliente(@Valid @RequestBody ClienteDto dto) throws ClienteExistenteException {
        Cliente clienteEntity = this.clienteMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.clienteMapper.mapToDto(this.clienteService.altaCliente(clienteEntity)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Permite vincular el vehiculo al cliente")
    public ResponseEntity<ClienteResponseDto> vincularVehiculo(@Valid @RequestBody VehiculoDto dto, @PathVariable Long id) throws VehiculoInexistenteException, ClienteInexistenteException {
        Vehiculo vehiculoEntity = this.vehiculoMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.clienteMapper.mapToDto(this.clienteService.vincularVehiculo(vehiculoEntity, id)), HttpStatus.OK);
    }

}
