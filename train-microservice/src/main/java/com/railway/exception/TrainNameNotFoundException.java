package com.railway.exception;

public class TrainNameNotFoundException extends RuntimeException {

	public TrainNameNotFoundException() {
		super();
	}

	public TrainNameNotFoundException(String message) {
		super(message);
	}
	
}
