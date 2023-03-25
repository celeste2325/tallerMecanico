package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.RepuestoDto;
import com.besysoft.taller_mecanico.dominio.entity.Repuesto;
import com.besysoft.taller_mecanico.dominio.mapstruct.RepuestoMapper;
import com.besysoft.taller_mecanico.service.interfaces.RepuestoService;
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
@RequestMapping("/repuestos")
@AllArgsConstructor
@Api(value = "Repuesto controller", tags = "Acciones permitidas para la entidad Repuesto")
public class RepuestoController {
    private final RepuestoMapper repuestoMapper;
    private final RepuestoService repuestoService;

    @PostMapping()
    @ApiOperation(value = "Permite dar de alta un repuesto")
    public ResponseEntity<RepuestoDto> altaRepuesto(@Valid @RequestBody RepuestoDto dto) {
        Repuesto repuestoEntity = this.repuestoMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.repuestoMapper.mapToDto(this.repuestoService.altaRepuesto(repuestoEntity)), HttpStatus.CREATED);
    }
}
