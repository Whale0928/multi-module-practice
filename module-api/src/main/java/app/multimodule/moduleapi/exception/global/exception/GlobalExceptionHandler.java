package app.multimodule.moduleapi.exception.global.exception;

import app.multimodule.moduleapi.exception.global.exception.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	private ResponseEntity<ErrorResponse> buildAndReturnResponse(HttpStatus status, String message) {
		log.error("\n [ Error ] {} : {}", now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd E HH:mm:ss")), message);
		return ResponseEntity.status(status).body(ErrorResponse.of(message, status));
	}

	private String getErrorMessage(String fieldName, Object rejectedValue) {
		return "유효하지 않은 파라미터입니다: " + fieldName + " [" + rejectedValue + "]";
	}


	/**
	 * MethodArgumentNotValidException handler
	 * 검증 에러등 발생시 발생하는 Exception
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return buildAndReturnResponse(BAD_REQUEST, exception.getBindingResult().getAllErrors().get(0).getDefaultMessage());
	}

	/**
	 * MethodArgumentTypeMismatchException handler
	 * enum 타입 파라미터에 잘못된 값이 들어왔을 때 발생하는 Exception
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
		String fieldName = exception.getName();
		String rejectedValue = Objects.requireNonNull(exception.getValue()).toString();
		return buildAndReturnResponse(HttpStatus.BAD_REQUEST, getErrorMessage(fieldName, rejectedValue));
	}


	/**
	 * Exception handler
	 * 그 외 모든 Exception
	 */
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {
		log.error("@ExceptionHandler Exception.class Message: {}", exception.getMessage());
		return buildAndReturnResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
	}


}
