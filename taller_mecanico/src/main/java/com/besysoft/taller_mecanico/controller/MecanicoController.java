package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.MecanicoDto;
import com.besysoft.taller_mecanico.dominio.entity.Mecanico;
import com.besysoft.taller_mecanico.dominio.mapstruct.MecanicoMapper;
import com.besysoft.taller_mecanico.service.interfaces.MecanicoService;
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
@RequestMapping("/mecanicos")
@AllArgsConstructor
@Api(value = "Mecanicos controller", tags = "Acciones permitidas para la entidad mecanico")
public class MecanicoController {
    private final MecanicoService mecanicoService;
    private final MecanicoMapper mecanicoMapper;

    @PostMapping()
    @ApiOperation(value = "Permite dar de alta un mecanico")
    public ResponseEntity<MecanicoDto> altaMecanico(@Valid @RequestBody MecanicoDto dto) {
        Mecanico mecanicoEntity = this.mecanicoMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.mecanicoMapper.mapToDto(this.mecanicoService.altaMecanico(mecanicoEntity)), HttpStatus.CREATED);
    }
}
