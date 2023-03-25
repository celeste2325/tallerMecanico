package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.OrdenTrabajoDto;
import com.besysoft.taller_mecanico.dominio.dto.response.OrdenDeTrabajoResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.mapstruct.OrdenTrabajoMapper;
import com.besysoft.taller_mecanico.excepciones.ErrorAlCambiarEstadoDeOrdenException;
import com.besysoft.taller_mecanico.excepciones.OrdenDeTrabajoInexistenteException;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ordenesTrabajo")
@AllArgsConstructor
@Api(value = "Orden trabajo controller", tags = "Acciones permitidas para la entidad OrdenTrabajo")
public class OrdenTrabajoController {

    private final OrdenTrabajoMapper ordenTrabajoMapper;
    private final OrdenTrabajoService ordenTrabajoService;

    @PostMapping()
    @ApiOperation(value = "Permite generar una orden de trabajo")
    public ResponseEntity<OrdenDeTrabajoResponseDto> altaCliente(@Valid @RequestBody OrdenTrabajoDto dto) {
        OrdenTrabajo ordenTrabajoEntity = this.ordenTrabajoMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.ordenTrabajoMapper.mapToDto(this.ordenTrabajoService.generarOrdenTrabajo(ordenTrabajoEntity)), HttpStatus.CREATED);
    }

    @PutMapping("/iniciarReparacion/{idOrden}")
    @ApiOperation(value = "Permite iniciar la reparacion, modificando estado de orden")
    public ResponseEntity<OrdenDeTrabajoResponseDto> iniciarReparacion(@PathVariable long idOrden) throws OrdenDeTrabajoInexistenteException, ErrorAlCambiarEstadoDeOrdenException {
        return new ResponseEntity<>(this.ordenTrabajoMapper.mapToDto(this.ordenTrabajoService.iniciarReparacion(idOrden)), HttpStatus.OK);
    }

    @PutMapping("/facturar/{idOrden}")
    @ApiOperation(value = "Permite modificar la orden de trabajo para facturar y cobrar")
    public ResponseEntity<OrdenDeTrabajoResponseDto> facturar(@Valid @RequestBody OrdenTrabajoDto orden, @PathVariable long idOrden) throws ErrorAlCambiarEstadoDeOrdenException, OrdenDeTrabajoInexistenteException {
        OrdenTrabajo ordenEntity = this.ordenTrabajoMapper.mapToEntity(orden);
        return new ResponseEntity<>(this.ordenTrabajoMapper.mapToDto(this.ordenTrabajoService.facturar(ordenEntity, idOrden)), HttpStatus.OK);
    }

    @PutMapping("/cerrarOrden/{idOrden}")
    @ApiOperation(value = "Permite cerrar la orden de trabajo, modificando estado de orden")
    public ResponseEntity<?> cerrarOrdenDeTrabajo(@PathVariable long idOrden) throws ErrorAlCambiarEstadoDeOrdenException, OrdenDeTrabajoInexistenteException {
        return new ResponseEntity<>(this.ordenTrabajoMapper.mapToDto(this.ordenTrabajoService.cerrarOrdenDeTrabajo(idOrden)), HttpStatus.OK);
    }

    //TODO FALTAN LOS TEST
    //TODO CONFIGURAR H2 PARA LOS TEST, CREAR ARCHIVO DE ESQUEMA Y DATOS PARA CARGAR DATOS AL INICIO O UTILIZAR UNA CLASE DUMMY


}
