package com.besysoft.taller_mecanico.dominio.dto;

import com.besysoft.taller_mecanico.dominio.entity.Mecanico;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManoDeObraDto {
    private Long id;
    private String detalle;
    private LocalDateTime duracionHs;
    private Mecanico mecanicosByMecanicoId;
    private OrdenTrabajo ordenesTrabajoByOrdenTrabajoId;
}
