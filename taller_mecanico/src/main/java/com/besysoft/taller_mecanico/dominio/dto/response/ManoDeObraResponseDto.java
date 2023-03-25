package com.besysoft.taller_mecanico.dominio.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManoDeObraResponseDto {
    private Long id;
    private String detalle;
    private LocalDateTime duracionHs;
}
