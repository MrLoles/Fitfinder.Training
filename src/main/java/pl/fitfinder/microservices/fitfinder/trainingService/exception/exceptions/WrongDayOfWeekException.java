package pl.fitfinder.microservices.fitfinder.trainingService.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongDayOfWeekException extends RuntimeException{
    public WrongDayOfWeekException(String message){super(message);}
}
