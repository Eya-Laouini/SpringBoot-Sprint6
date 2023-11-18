package com.ons.users.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class EnabledException {
        @ExceptionHandler(UserAccountNotEnabledException.class)
        @ResponseBody
        public ResponseEntity<String> handleUserAccountNotEnabledException(UserAccountNotEnabledException ex) {
            return ResponseEntity.status(403).body(ex.getMessage());
        }
}
