package com.globomart.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductError {

	private String message;

	private List<FieldError> errors;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

	public class FieldError {
		private String field;
		private String message;

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public FieldError(String field, String message) {
			super();
			this.field = field;
			this.message = message;
		}

	}

	public void addFieldError(String field, String message) {
		if (errors == null)
			errors = new ArrayList<>();

		errors.add(new FieldError(field, message));
	}
}
