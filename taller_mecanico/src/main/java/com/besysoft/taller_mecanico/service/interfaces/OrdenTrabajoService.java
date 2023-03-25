package com.besysoft.taller_mecanico.service.interfaces;

import com.besysoft.taller_mecanico.dominio.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.excepciones.ErrorAlCambiarEstadoDeOrdenException;
import com.besysoft.taller_mecanico.excepciones.OrdenDeTrabajoInexistenteException;

import java.util.List;

public interface OrdenTrabajoService {
    OrdenTrabajo generarOrdenTrabajo(OrdenTrabajo ordenTrabajo);

    OrdenTrabajo iniciarReparacion(long idOrden) throws OrdenDeTrabajoInexistenteException, ErrorAlCambiarEstadoDeOrdenException;

    OrdenTrabajo cerrarOrdenDeTrabajo(long idOrden) throws ErrorAlCambiarEstadoDeOrdenException, OrdenDeTrabajoInexistenteException;

    void cargarRepuestos(OrdenTrabajo ordenTrabajo, List<DetalleOrdenTrabajo> detalleOrdenesTrabajosParaAgregar);

    OrdenTrabajo facturar(OrdenTrabajo orden, long idOrden) throws OrdenDeTrabajoInexistenteException, ErrorAlCambiarEstadoDeOrdenException;
}
