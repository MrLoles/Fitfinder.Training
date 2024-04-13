package pl.fitfinder.microservices.fitfinder.trainingService.exception.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AuthorizationFailException extends RuntimeException {
    public AuthorizationFailException(String message){super(message);}
}
