package app.multimodule.moduleapi.exception.global.exception.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
public class ErrorResponse {
    private final String message;
    private final HttpStatus status;
    private final LocalDateTime timestamp;

    private ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        timestamp = now();
    }

    public static ErrorResponse of(String message, HttpStatus status) {
        return new ErrorResponse(message, status);
    }
}
