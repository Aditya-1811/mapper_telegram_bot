package com.example.mapping.Error;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@ControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler {

    public static class GenderNotFound extends RuntimeException {
        String var;
        public GenderNotFound(Set<String> a) {
            super("Enter a valid gender of type " + a.toString());
            var = "Enter a valid gender of type "+ a.toString();
        }

        @Override
        public String toString() {
            return var;
        }
    }

    public static class Error extends RuntimeException {
        String var;
        public Error(Set<String> a) {
            super("Enter a valid input of type "+a.toString());
            var = "Enter a valid input of type "+ a.toString();
        }

        @Override
        public String toString() {
            return var;
        }
    }




    @ExceptionHandler(Error.class)
    public ResponseEntity<CustomErrorResponse> customHandleNotFound3(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(HttpStatus.NOT_FOUND.value());


        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }


    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());


        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);
    }
}
