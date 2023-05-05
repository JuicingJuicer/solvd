package com.solvd.ta.lab2.exceptions;

public class OutOfRangeException extends RuntimeException {
	public OutOfRangeException(String message) {
		super(message);
	}

	public OutOfRangeException(Throwable cause) {
		super(cause);
	}
}
