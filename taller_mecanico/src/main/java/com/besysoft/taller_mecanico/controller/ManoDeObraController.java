package com.besysoft.taller_mecanico.controller;

import com.besysoft.taller_mecanico.dominio.dto.ManoDeObraDto;
import com.besysoft.taller_mecanico.dominio.dto.response.ManoDeObraResponseDto;
import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import com.besysoft.taller_mecanico.dominio.mapstruct.ManoDeObraMapper;
import com.besysoft.taller_mecanico.excepciones.ManoDeObraInexistente;
import com.besysoft.taller_mecanico.excepciones.OrdenDeTrabajoInexistenteException;
import com.besysoft.taller_mecanico.service.interfaces.ManoDeObraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/manosDeObra")
@AllArgsConstructor
@Api(value = "Mano de obra controller", tags = "Acciones permitidas para la entidad mano_obra")
public class ManoDeObraController {

    private final ManoDeObraService manDeObraService;
    private final ManoDeObraMapper manoDeObraMapper;

    @PostMapping()
    @ApiOperation(value = "Permite generar una mano de obra")
    public ResponseEntity<ManoDeObraResponseDto> GenerarManoDeObra(@Valid @RequestBody ManoDeObraDto dto) {
        ManoObra manoObraEntity = this.manoDeObraMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.manoDeObraMapper.mapToDto(this.manDeObraService.generarManoDeObra(manoObraEntity)), HttpStatus.CREATED);
    }

    @PutMapping("/{idManoObra}")
    @ApiOperation(value = "Permite finalizar la reparacion, completando la mano de obra")
    public ResponseEntity<ManoDeObraResponseDto> FinalizarReparacion(@Valid @RequestBody ManoDeObraDto dto, @PathVariable long idManoObra) throws ManoDeObraInexistente, OrdenDeTrabajoInexistenteException {
        ManoObra manoObraEntity = this.manoDeObraMapper.mapToEntity(dto);
        return new ResponseEntity<>(this.manoDeObraMapper.mapToDto(this.manDeObraService.finalizarReparacion(manoObraEntity, idManoObra)), HttpStatus.OK);
    }
}
