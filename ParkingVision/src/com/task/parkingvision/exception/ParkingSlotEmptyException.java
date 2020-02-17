package com.task.parkingvision.exception;

public class ParkingSlotEmptyException extends Exception {
	
	public ParkingSlotEmptyException() {
    }

    public ParkingSlotEmptyException(String message) {
        super(message);
    }

}
