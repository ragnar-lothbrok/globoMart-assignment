package com.globomart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.globomart.dto.ProductError;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ProductError processError(RuntimeException ex) {
		ProductError nwookError = new ProductError();
		nwookError.setMessage(ex.getMessage());
		return nwookError;
	}

}
