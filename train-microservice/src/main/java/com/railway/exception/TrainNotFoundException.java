package com.railway.exception;

public class TrainNotFoundException extends RuntimeException {

	public TrainNotFoundException() {
		super();
	}

	public TrainNotFoundException(String message) {
		super(message);
	}
	
}
