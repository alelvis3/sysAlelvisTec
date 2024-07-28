package br.com.alelvis3.sysAlelvisTec.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // Indica que esta classe lida com exceções em nível global para os controladores REST
public class GlobalExceptionHandler {

    // Método para tratar exceções de validação de argumentos de método
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); // Mapa para armazenar os erros de validação
        ex.getBindingResult().getAllErrors().forEach(error -> { // Itera sobre todos os erros de validação
            String fieldName = ((FieldError) error).getField(); // Obtém o nome do campo que causou o erro
            String errorMessage = error.getDefaultMessage(); // Obtém a mensagem de erro padrão
            errors.put(fieldName, errorMessage); // Adiciona o campo e a mensagem de erro ao mapa
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors); // Retorna um ResponseEntity com status 400 e o mapa de erros
    }

    // Método para tratar exceções gerais
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()); // Retorna um ResponseEntity com status 500 e a mensagem da exceção
    }
}