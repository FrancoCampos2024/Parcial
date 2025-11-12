package com.example.Movimiento.excepciones;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class Controladordeexcepcionesglobal {

     private static final Logger logger = LoggerFactory.getLogger(Controladordeexcepcionesglobal.class);

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        String errores = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        DetalleError errorDetails = new DetalleError(
                HttpStatus.BAD_REQUEST.value(),
                errores,
                request.getDescription(false)
        );

        logger.warn("Error de validación: {} | Ruta: {}", errores, request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


    // 🔹 Captura de errores generales (otros no manejados)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
        DetalleError errorDetails = new DetalleError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false)
        );

        // 📄 Guardar el error completo (con stack trace)
        logger.error("Error general: {} | Ruta: {}", ex.getMessage(), request.getDescription(false), ex);

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}