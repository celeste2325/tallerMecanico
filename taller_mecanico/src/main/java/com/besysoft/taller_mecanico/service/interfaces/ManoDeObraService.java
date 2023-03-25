package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import com.besysoft.taller_mecanico.excepciones.ManoDeObraInexistente;
import com.besysoft.taller_mecanico.excepciones.OrdenDeTrabajoInexistenteException;

public interface ManoDeObraService {
    ManoObra generarManoDeObra(ManoObra manoObra);

    ManoObra finalizarReparacion(ManoObra manoObra, long idManoObra) throws ManoDeObraInexistente, OrdenDeTrabajoInexistenteException;
}
