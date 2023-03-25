package com.besysoft.taller_mecanico.service.implementations;

import com.besysoft.taller_mecanico.dominio.EstadoOrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.DetalleOrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.OrdenTrabajo;
import com.besysoft.taller_mecanico.dominio.entity.Repuesto;
import com.besysoft.taller_mecanico.excepciones.ErrorAlCambiarEstadoDeOrdenException;
import com.besysoft.taller_mecanico.excepciones.OrdenDeTrabajoInexistenteException;
import com.besysoft.taller_mecanico.repositories.MecanicoRepository;
import com.besysoft.taller_mecanico.repositories.OrdenTrabajoRepository;
import com.besysoft.taller_mecanico.repositories.RepuestoRepository;
import com.besysoft.taller_mecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoServiceImplement implements OrdenTrabajoService {
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final MecanicoRepository mecanicoRepository;
    private final RepuestoRepository repuestoRepository;

    public OrdenTrabajoServiceImplement(OrdenTrabajoRepository ordenTrabajoRepository, MecanicoRepository mecanicoRepository, RepuestoRepository repuestoRepository) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.mecanicoRepository = mecanicoRepository;
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public OrdenTrabajo generarOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        ordenTrabajo.setFechaIngreso(LocalDateTime.now());
        ordenTrabajo.setEstado(String.valueOf(EstadoOrdenTrabajo.CREADA));
        return this.ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Override
    public OrdenTrabajo iniciarReparacion(long idOrden) throws OrdenDeTrabajoInexistenteException, ErrorAlCambiarEstadoDeOrdenException {
        Optional<OrdenTrabajo> ordenTrabajo = this.ordenTrabajoRepository.findById(idOrden);
        if (ordenTrabajo.isPresent()) {
            if (ordenTrabajo.get().getEstado().equalsIgnoreCase(String.valueOf(EstadoOrdenTrabajo.CREADA))) {
                ordenTrabajo.get().setEstado(String.valueOf(EstadoOrdenTrabajo.EN_REPARACION));
                return this.ordenTrabajoRepository.save(ordenTrabajo.get());
            }
            throw new ErrorAlCambiarEstadoDeOrdenException("No se puede actualizar el estado de la orden a en reparacion ya que la misma debe estar en estado creada");
        }
        throw new OrdenDeTrabajoInexistenteException("No existe la orden de trabajo");
    }

    @Override
    public OrdenTrabajo cerrarOrdenDeTrabajo(long idOrden) throws ErrorAlCambiarEstadoDeOrdenException, OrdenDeTrabajoInexistenteException {
        Optional<OrdenTrabajo> ordenTrabajo = this.ordenTrabajoRepository.findById(idOrden);
        if (ordenTrabajo.isPresent()) {
            if (ordenTrabajo.get().getEstado().equalsIgnoreCase(String.valueOf(EstadoOrdenTrabajo.FACTURADA))) {
                ordenTrabajo.get().setEstado(String.valueOf(EstadoOrdenTrabajo.CERRADA));
                return this.ordenTrabajoRepository.save(ordenTrabajo.get());
            }
            throw new ErrorAlCambiarEstadoDeOrdenException("No se puede cerrar la orden ya que la misma no se encuentra facturada");
        }
        throw new OrdenDeTrabajoInexistenteException("No existe la orden de trabajo");
    }

    @Override
    public void cargarRepuestos(OrdenTrabajo ordenTrabajo, List<DetalleOrdenTrabajo> detalleOrdenesTrabajosParaAgregar) {
        //orden de trabajo asociada a la mano de obra
        List<DetalleOrdenTrabajo> detallesDeOrdenesExistente = ordenTrabajo.getDetalleOrdenesTrabajosById();

        //se cargan los repuestos
        detalleOrdenesTrabajosParaAgregar.forEach(detOrden ->
        {

            if (!detallesDeOrdenesExistente.contains(detOrden)) {
                Optional<Repuesto> repuesto = this.repuestoRepository.findById(detOrden.getRepuestosByRepuestoId().getId());
                if (repuesto.isPresent()) {
                    //calcula el valor total del detalle de compra
                    BigDecimal totalDetalleCompra = repuesto.get().getValor().multiply(BigDecimal.valueOf(detOrden.getCantidad().longValue()));
                    detOrden.setValorTotal(totalDetalleCompra);
                    detallesDeOrdenesExistente.add(detOrden);
                }
            }
        });
        this.ordenTrabajoRepository.save(ordenTrabajo);

    }

    @Override
    public OrdenTrabajo facturar(OrdenTrabajo orden, long idOrden) throws OrdenDeTrabajoInexistenteException, ErrorAlCambiarEstadoDeOrdenException {
        Optional<OrdenTrabajo> ordenEncontrada = this.ordenTrabajoRepository.findById(idOrden);
        if (ordenEncontrada.isPresent()) {
            if (ordenEncontrada.get().getEstado().equalsIgnoreCase(String.valueOf(EstadoOrdenTrabajo.PARA_FACTURAR))) {
                if (ordenEncontrada.get().getDetalleOrdenesTrabajosById().size() > 0) {
                    ordenEncontrada.get().getDetalleOrdenesTrabajosById().forEach(ord -> {
                        if (ordenEncontrada.get().getImporteTotal() == null) {
                            ordenEncontrada.get().setImporteTotal(ord.getValorTotal());
                        }
                        ordenEncontrada.get().setImporteTotal(ordenEncontrada.get().getImporteTotal().add(ord.getValorTotal()));
                    });
                }
                //actualizando los campos
                ordenEncontrada.get().setEstado(String.valueOf(EstadoOrdenTrabajo.FACTURADA));
                ordenEncontrada.get().setEmpleadosByAdmnistrativoId(orden.getEmpleadosByAdmnistrativoId());
                ordenEncontrada.get().setFormaPago(orden.getFormaPago());
                ordenEncontrada.get().setTipoTarjeta(orden.getTipoTarjeta());
                ordenEncontrada.get().setCantidadCuotas(orden.getCantidadCuotas());
                ordenEncontrada.get().setFechaPago(LocalDateTime.now());
                return this.ordenTrabajoRepository.save(ordenEncontrada.get());
            }
            throw new ErrorAlCambiarEstadoDeOrdenException("No se puede cambiar el estado de la orden a facturada ya que la misma no se encuentra en estado para facturar");

        }
        throw new OrdenDeTrabajoInexistenteException("No existe la orden de trabajo");
    }
}
