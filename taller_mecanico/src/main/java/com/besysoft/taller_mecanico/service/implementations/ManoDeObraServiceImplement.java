package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.EstadoOrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.ManoObra;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.excepciones.ManoDeObraInexistente;
import com.besysoft.taller_mecanico.excepciones.OrdenDeTrabajoInexistenteException;
import com.besysoft.taller_mecanico.repositories.ManoDeObraRepository;
import com.besysoft.taller_mecanico.repositories.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.service.interfaces.ManoDeObraService;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ManoDeObraServiceImplement implements ManoDeObraService {
    private final ManoDeObraRepository manoDeObraRepository;
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final OrdenTrabajoService ordenTrabajoService;

    public ManoDeObraServiceImplement(ManoDeObraRepository manoDeObraRepository, OrdenTrabajoRepository ordenTrabajoRepository, OrdenTrabajoService ordenTrabajoService) {
        this.manoDeObraRepository = manoDeObraRepository;
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.ordenTrabajoService = ordenTrabajoService;
    }

    @Override
    public ManoObra generarManoDeObra(ManoObra manoObra) {
        return this.manoDeObraRepository.save(manoObra);
    }

    @Override
    public ManoObra finalizarReparacion(ManoObra dto, long idManoObra) throws ManoDeObraInexistente, OrdenDeTrabajoInexistenteException {
        Optional<ManoObra> manoObra = this.manoDeObraRepository.findById(idManoObra);
        //se completa la mano de obra
        if (manoObra.isPresent()) {
            manoObra.get().setDetalle(dto.getDetalle());
            manoObra.get().setDuracionHs(dto.getDuracionHs());

            Optional<OrdenTrabajo> ordenTrabajoAsociada = this.ordenTrabajoRepository.findById(manoObra.get().getOrdenesTrabajoByOrdenTrabajoId().getId());
            //detalles de orden para agregar
            List<DetalleOrdenTrabajo> detalleOrdenesTrabajosParaAgregar = dto.getOrdenesTrabajoByOrdenTrabajoId().getDetalleOrdenesTrabajosById();

            //si existe la orden y ademas  hay detalles para agregar
            if (ordenTrabajoAsociada.isPresent() && detalleOrdenesTrabajosParaAgregar.size() > 0) {
                this.ordenTrabajoService.cargarRepuestos(ordenTrabajoAsociada.get(), detalleOrdenesTrabajosParaAgregar);

                //se cambia el estado a facturar
                ordenTrabajoAsociada.get().setEstado(String.valueOf(EstadoOrdenTrabajo.PARA_FACTURAR));
                //se setea la fecha de fin de reparacion
                ordenTrabajoAsociada.get().setFechaFinReparacion(LocalDateTime.now());
                return this.manoDeObraRepository.save(manoObra.get());
            }
            throw new OrdenDeTrabajoInexistenteException("No hay una orden de trabajo asociada a la mano de obra");

        }
        throw new ManoDeObraInexistente("No existe la mano de obra");
    }
}
