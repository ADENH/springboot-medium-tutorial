package com.demo.medium.config.exception;

import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.medium.dto.response.ResponseBase;
import com.demo.medium.dto.response.ResponseTemplateHeader;
import com.demo.medium.model.ErrorResponse;

import feign.FeignException;

/**
 * Created by Spring Tool Suite.
 * @author Ade Hidayat
 * Date: Apr 3, 2021
 * Time: 11:04:50 AM
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error, ex));
	}

	private ResponseEntity<Object> buildResponseEntity(ErrorResponse apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	private ResponseEntity<Object> buildResponseEntity(ResponseBase apiError) {
		return new ResponseEntity<>(apiError, apiError.getHeader().getStatusCode());
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> handleEntityNotFound(NoSuchElementException ex) {
		ErrorResponse apiError = new ErrorResponse(HttpStatus.NOT_FOUND,ex);
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(FeignException.class)
	protected ResponseEntity<Object> handleFeignException(FeignException ex) {
		ResponseTemplateHeader header = new ResponseTemplateHeader();
		header.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		header.setResponseType(MediaType.APPLICATION_JSON_VALUE);
		ResponseBase res = new ResponseBase();
		res.setHeader(header);
		res.setMessage(ex.getLocalizedMessage());
		return buildResponseEntity(res);
	}


}
