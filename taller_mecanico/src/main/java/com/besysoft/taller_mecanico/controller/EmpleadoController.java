package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.EmpleadoDto;
import com.besysoft.taller_mecanico.dominio.entity.Empleado;
import com.besysoft.taller_mecanico.dominio.mapstruct.EmpleadoMapper;
import com.besysoft.taller_mecanico.service.interfaces.EmpleadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/empleados")
@AllArgsConstructor
@Api(value = "Empleado controller", tags = "Acciones permitidas para la entidad Empleado")
public class EmpleadoController {
    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoService empleadoService;

    @PostMapping()
    @ApiOperation(value = "Permite dar de alta un empleado")
    public ResponseEntity<EmpleadoDto> altaEmpleado(@Valid @RequestBody EmpleadoDto dto) {
        Empleado empleadoEntity = this.empleadoMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.empleadoMapper.mapToDto(this.empleadoService.altaEmpleado(empleadoEntity)), HttpStatus.CREATED);
    }
}
