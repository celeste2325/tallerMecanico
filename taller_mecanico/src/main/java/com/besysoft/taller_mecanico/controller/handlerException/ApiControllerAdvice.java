package com.besysoft.taller_mecanico.controller.handlerException;

import com.besysoft.taller_mecanico.dominio.dto.response.ExceptionDto;
import com.besysoft.taller_mecanico.excepciones.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto exceptionHandler(MethodArgumentNotValidException ex) {
        List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
        Map<String, String> detalle = new HashMap<>();
        errorList.forEach(e -> detalle.put(e.getField(), e.getDefaultMessage()));
        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Validaciones", detalle);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto ClienteExistente(ClienteExistenteException ex) {
        log.error("ocurrio un error porque ya existe el cliente", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto VehiculoExistente(VehiculoExistenteException ex) {
        log.error("ocurrio un error porque ya existe el vehiculo", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto VehiculoInexistente(VehiculoInexistenteException ex) {
        log.error("ocurrio un error porque el vehiculo que se quiere vincular no existe", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto clienteInexistente(ClienteInexistenteException ex) {
        log.error("ocurrio un error porque el cliente recepcionado no existe", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto OrdenDeTrabajoInexistente(OrdenDeTrabajoInexistenteException ex) {
        log.error("ocurrio un error porque la orden de trabajo no existe", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto ManoDeObraInexistente(ManoDeObraInexistente ex) {
        log.error("ocurrio un error porque la mano de obra no existe", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDto errorCambioDeEstado(ErrorAlCambiarEstadoDeOrdenException ex) {
        log.error("ocurrio un error porque se quiere cambiar de estado de facturado a cerrado y la orden aun no esta en estado facturado", ex);
        return new ExceptionDto(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }
}
