package br.com.ufpe.agenda.exception;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.ufpe.agenda.exception.ErrorResponse.ApiError;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerController {

	private static final String NO_MESSAGE_AVAILABLE = "No message available";
	private static final  Logger LOG = LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	private final MessageSource apiErrorMessageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleNotValidException(MethodArgumentNotValidException exception,
			Locale locale) {
		
		Stream<ObjectError> errors = exception.getBindingResult().getAllErrors().stream();
		
		List<ApiError> apiErros = errors
				.map(ObjectError::getDefaultMessage)
				.map(code -> toApiError(code, locale))
				.collect(Collectors.toList());
		
		ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, apiErros);
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<ErrorResponse> handleNegocioException(NegocioException exception, Locale locale) {
		final String errorCode = exception.getMessage();
		final HttpStatus status = exception.getStatus();
		final ErrorResponse errorResponse = ErrorResponse.of(status, toApiError(errorCode, locale));
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validateError(ConstraintViolationException ex){
        return ResponseEntity.badRequest().body(ex.getConstraintViolations()
        		.stream().map(cv -> cv.getMessage()).collect(Collectors.toList()));
    }
	
	public ApiError toApiError(String code, Locale locale) {
		String message;
		try {
			message = apiErrorMessageSource.getMessage(code, null, locale);
		} catch (NoSuchMessageException e) {
			LOG.error("Could not find any message for {} code under {} locale", code, locale);
			message = NO_MESSAGE_AVAILABLE;
		}
		
		return new ApiError(code, message);
	}
	
}
