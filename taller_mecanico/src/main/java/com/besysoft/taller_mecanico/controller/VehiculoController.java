package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.VehiculoDto;
import com.besysoft.taller_mecanico.dominio.entity.Vehiculo;
import com.besysoft.taller_mecanico.dominio.mapstruct.VehiculoMapper;
import com.besysoft.taller_mecanico.excepciones.VehiculoExistenteException;
import com.besysoft.taller_mecanico.service.interfaces.VehiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/vehiculos")
@AllArgsConstructor
@Slf4j
@Api(value = "Vehiculos controller", tags = "Acciones permitidas para la entidad Vehiculo")
public class VehiculoController {
    private final VehiculoService vehiculoService;
    private final VehiculoMapper vehiculoMapper;

    @PostMapping()
    @ApiOperation(value = "Permite dar de alta un vehiculo")
    public ResponseEntity<?> altaVehiculo(@Valid @RequestBody VehiculoDto dto) throws VehiculoExistenteException {
        Vehiculo vehiculoEntity = this.vehiculoMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.vehiculoMapper.mapToDto(this.vehiculoService.altaVehiculo(vehiculoEntity)), HttpStatus.CREATED);
    }
}
