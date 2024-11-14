package com.kevin.gestionhistoriaclinica.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;

@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler extends
                DataFetcherExceptionResolverAdapter {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public GraphQLError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
                Map<String, String> mapErrors = new HashMap<>();
                exception.getBindingResult().getAllErrors().forEach(error -> {
                        String field = ((FieldError) error).getField();
                        String message = error.getDefaultMessage();
                        mapErrors.put(field, message);
                });

                return GraphqlErrorBuilder.newError()
                                .message("Validation failed")
                                .extensions(Map.of("errors", mapErrors))
                                .errorType(ErrorType.BAD_REQUEST)
                                .build();
        }

        @ExceptionHandler(ResourceNotFoundException.class)
        public GraphQLError handleResourceNotFoundException(ResourceNotFoundException exception) {
                return GraphqlErrorBuilder.newError()
                                .message(exception.getMessage())
                                .errorType(ErrorType.NOT_FOUND)
                                .build();
        }

        @ExceptionHandler(NoHandlerFoundException.class)
        public GraphQLError handleNoHandlerFoundException(NoHandlerFoundException exception) {
                return GraphqlErrorBuilder.newError()
                                .message("No handler found for the requested path")
                                .errorType(ErrorType.NOT_FOUND)
                                .build();
        }

        @ExceptionHandler(BadRequestException.class)
        public GraphQLError handleBadRequestException(BadRequestException exception) {
                return GraphqlErrorBuilder.newError()
                                .message(exception.getMessage())
                                .errorType(ErrorType.BAD_REQUEST)
                                .build();
        }

        @ExceptionHandler(Exception.class)
        public GraphQLError handleException(Exception exception) {
                return GraphqlErrorBuilder.newError()
                                .message("Internal server error: " + exception.getMessage())
                                .errorType(ErrorType.INTERNAL_ERROR)
                                .build();
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public GraphQLError handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
                String message = "Integrity violation: Unable to delete or modify due to dependencies.";
                return GraphqlErrorBuilder.newError()
                                .message(message)
                                .errorType(ErrorType.BAD_REQUEST)
                                .build();
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public GraphQLError handleIllegalArgumentException(IllegalArgumentException exception) {
                return GraphqlErrorBuilder.newError()
                                .message(exception.getMessage())
                                .errorType(ErrorType.BAD_REQUEST)
                                .build();
        }

        @ExceptionHandler(IllegalStateException.class)
        public GraphQLError handleIllegalStateException(IllegalStateException exception) {
                return GraphqlErrorBuilder.newError()
                                .message(exception.getMessage())
                                .errorType(ErrorType.BAD_REQUEST)
                                .build();
        }
}