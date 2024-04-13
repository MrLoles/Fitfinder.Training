package pl.fitfinder.microservices.fitfinder.trainingService.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;
    private final String microserviceName;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        microserviceName = "Auth";
    }
}
