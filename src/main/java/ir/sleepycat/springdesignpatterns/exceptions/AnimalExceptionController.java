package ir.sleepycat.springdesignpatterns.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AnimalExceptionController {

    @ExceptionHandler(value = AnimalNotFoundException.class)
    public ResponseEntity<Object> exception(AnimalNotFoundException exception) {
        return new ResponseEntity<>("Animal not found", HttpStatus.NOT_FOUND);
    }

}
