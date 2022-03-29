package ua.lviv.dataart.restfulwebservices.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ua.lviv.dataart.restfulwebservices.exception.NotFoundException;

import java.time.ZonedDateTime;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiException> handleNotFoundExceptions(RuntimeException e) {
        HttpStatus notFoundStatus = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(e.getMessage(), notFoundStatus, ZonedDateTime.now());
        return new ResponseEntity<>(apiException, notFoundStatus);
    }

}
