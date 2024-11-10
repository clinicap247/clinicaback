package com.kevin.gestionhistoriaclinica.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.kevin.gestionhistoriaclinica.models.payloads.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

        // Validaciones
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Object> handlderMethodArgumentNotValidException(MethodArgumentNotValidException exception,
                        WebRequest webRequest) {
                Map<String, String> mapErrors = new HashMap<>();
                exception.getBindingResult().getAllErrors().forEach((error) -> {
                        String clave = ((FieldError) error).getField();
                        String valor = error.getDefaultMessage();
                        mapErrors.put(clave, valor);
                });
                ApiResponse apiResponse = new ApiResponse("Fallo la Validación",
                                webRequest.getDescription(false), mapErrors);
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }

        // 404 Regestionhistoriaclinica no encontrado
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception,
                        WebRequest webRequest) {
                // descripcion en false para no obtener toda la info
                ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                                webRequest.getDescription(false));
                return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

        // 404 Path no encontrado
        @ExceptionHandler(NoHandlerFoundException.class)
        public ResponseEntity<ApiResponse> handlerNoHandlerFoundException(NoHandlerFoundException exception,
                        WebRequest webRequest) {
                ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                                webRequest.getDescription(false));
                return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }

        // 400 Errores de logica o de los catch
        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<ApiResponse> handlerBadRequestException(BadRequestException exception,
                        WebRequest webRequest) {
                ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                                webRequest.getDescription(false));
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }

        // Errores de varios tipos y globalizrlo con un error 500
        @ExceptionHandler(Exception.class)
        public ResponseEntity<ApiResponse> handlerException(Exception exception,
                        WebRequest webRequest) {
                System.out.println(webRequest);
                ApiResponse apiResponse = new ApiResponse(exception.getMessage(),
                                webRequest.getDescription(false));
                return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        // Manejo de la excepción por violación de integridad referencial
        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ApiResponse> handleDataIntegrityViolationException(
                        DataIntegrityViolationException exception,
                        WebRequest webRequest) {
                String mensaje = "No se puede eliminar el regestionhistoriaclinica porque está siendo referenciado por otro regestionhistoriaclinica.";
                ApiResponse apiResponse = new ApiResponse(mensaje,
                                webRequest.getDescription(false));
                return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }
}
