package com.task.parkingvision.parkingservice;

import com.task.parkingvision.exception.ParkingSlotEmptyException;
import com.task.parkingvision.exception.ParkingSlotFullException;
import com.task.parkingvision.exception.VechileNotFoundException;

public interface IParkingService {

	void parkCar() throws ParkingSlotFullException;
	void pickupCar(String carNumber) throws VechileNotFoundException, ParkingSlotEmptyException;
	void getSlotByCarColour(String carColour) throws VechileNotFoundException, NullPointerException;
	void getSlotByCarNumber(String carNumber) throws VechileNotFoundException, NullPointerException;
	void getCarNumberByCarColour(String carColour) throws VechileNotFoundException;
}
