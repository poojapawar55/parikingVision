package com.task.parkingvision.exception;

public class ParkingSlotFullException extends Exception {
	
	private static final long serialVersionUID = 1L;
	 public ParkingSlotFullException() {
	    }

	 public ParkingSlotFullException(String message) {
	        super(message);
	    }
}
