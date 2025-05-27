package com.railway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
	
		@ExceptionHandler(TrainNotFoundException.class)
		public ResponseEntity<String> handleTrainNotFound(TrainNotFoundException ex) {
		    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}

	    @ExceptionHandler(TrainNameNotFoundException.class)
	    public ResponseEntity<String> handleTrainNameNotFound(TrainNameNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

}
