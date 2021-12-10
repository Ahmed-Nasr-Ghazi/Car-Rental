package com.rent.crud.exception;

public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException() {

	}

	public CarNotFoundException(String message) {
		super(message);

	}

	public CarNotFoundException(Throwable cause) {
		super(cause);

	}

	public CarNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CarNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
