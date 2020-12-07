package own.development.avengers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import own.development.avengers.exception.AvengersNotFound;

@ControllerAdvice
public class AvengersControllerAdvice {
    @ResponseBody
    @ExceptionHandler(AvengersNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String heroNotFoundHandler (AvengersNotFound exception) {
        return exception.getMessage();
    }

}
