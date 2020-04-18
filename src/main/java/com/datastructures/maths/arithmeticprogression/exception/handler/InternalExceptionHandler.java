package com.datastructures.maths.arithmeticprogression.exception.handler;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.datastructures.maths.arithmeticprogression.exception.ApiError;
import com.datastructures.maths.arithmeticprogression.exception.InternalException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class InternalExceptionHandler extends ResponseEntityExceptionHandler {
	
	public InternalExceptionHandler() {
		super();
	}
	
	@ExceptionHandler({ InternalException.class })
	protected ResponseEntity<ApiError> handleOutcomeCode(Exception e, WebRequest request) {
		ApiError obj = new ApiError();
		InternalException re = (InternalException) e;
		obj.setOutComeCode(re.getOutcomeCode());
		obj.setOutComeMessage(re.getOutcomeMessage());
		obj.setDeveloperMessage(re.getInternalMessage());
		log.error("Internal Exception - OutcomeCode: " + re.getOutcomeCode() + " Message: " + re.getOutcomeMessage());
		return new ResponseEntity(obj, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected final ResponseEntity<Object> handleHttpMessageNotReadable(final HttpMessageNotReadableException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request){
		
		return handleExceptionInternal(ex, message(HttpStatus.BAD_REQUEST,ex), headers, status, request);
	}
	
	@Override
	protected final ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
			final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST,
				request);

	}
	
	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	public final ResponseEntity<Object> handleBadRequest(final DataIntegrityViolationException ex,
			final WebRequest request) {

		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(IOException.class)
	public final ResponseEntity<Object> handleIOException(IOException ex, final WebRequest request) {

		logger.error("handleIOException - Catching: " + ex.getClass().getSimpleName());
		return handleExceptionInternal(ex, message2(HttpStatus.REQUEST_TIMEOUT, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);

	}

	@ExceptionHandler(JWTDecodeException.class)
	public final ResponseEntity<Object> JWTDecodeExceptions(JWTDecodeException ex, final WebRequest request) {

		logger.error("handlejwtdecodeException - Catching: " + ex.getClass().getSimpleName());
		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);

	}
	
	
	
	@ExceptionHandler(JWTVerificationException.class)
	public final ResponseEntity<Object> JWTVerificationExceptions(JWTVerificationException ex,
			final WebRequest request) {

		logger.error("handlejwtverificationException - Catching: " + ex.getClass().getSimpleName());
		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);

	}
	
	
	@ExceptionHandler(TokenExpiredException.class)
	public final ResponseEntity<Object> TokenExpiredExceptions(TokenExpiredException ex, final WebRequest request) {

		logger.error("handlejwtdecodeException - Catching: " + ex.getClass().getSimpleName());
		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);

	}
	
	@Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error("handleServletRequestBindingException - Catching: " + ex.getClass().getSimpleName());
		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
    }
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.error("handleHttpMediaTypeNotSupported - Catching: " + ex.getClass().getSimpleName());
		return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}
	  
	  @Override
	    protected ResponseEntity<Object> handleNoHandlerFoundException(
	      NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    	logger.error("handleNoHandlerFoundException - Catching: " + ex.getClass().getSimpleName());
			return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
					HttpStatus.BAD_REQUEST, request);
	    }
	
		/*
		 * @Override protected ResponseEntity<Object>
		 * handleHttpMediaTypeNotSupportedException( HttpMediaTypeNotSupportedException
		 * ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		 * logger.error("HttpMediaTypeNotSupportedException - Catching: " +
		 * ex.getClass().getSimpleName()); return handleExceptionInternal(ex,
		 * message(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
		 * HttpStatus.BAD_REQUEST, request); }
		 */
	  
	  @Override
	    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status,
	            WebRequest request) {    
	    	logger.error("handleHttpRequestMethodNotSupported - Catching: " + ex.getClass().getSimpleName());
			return handleExceptionInternal(ex, message2(HttpStatus.BAD_REQUEST, ex), new HttpHeaders(),
					HttpStatus.BAD_REQUEST, request);
	    }
	  
	
	private InternalException message(final HttpStatus httpstatus, final Exception ex) {
		
		final String outcomeMessage = ex.getMessage() ==null ? ex.getClass().getSimpleName() : ex.getMessage();
		final String internalMessage = ExceptionUtils.getRootCauseMessage(ex);
		return new InternalException(httpstatus.value(), outcomeMessage, internalMessage);
		
	}
	
	
	private ApiError message2(final HttpStatus httpStatus, final Exception ex) {
		final String message = ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
		final String devMessage = ExceptionUtils.getRootCauseMessage(ex);

		return new ApiError(httpStatus.value(), message, devMessage);
	}

}
