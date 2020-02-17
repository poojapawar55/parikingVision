package com.task.parkingvision.model;

public class ParkedVehicle {

	public String carNumber;
	public String carColour;
	public int slotNumber;
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarColour() {
		return carColour;
	}
	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	public ParkedVehicle(String carNumber, String carColour, int slotNumber) {
		super();
		this.carNumber = carNumber;
		this.carColour = carColour;
		this.slotNumber = slotNumber;
	}
	public ParkedVehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ParkedVehicle [carNumber=" + carNumber + ", carColour=" + carColour + ", slotNumber=" + slotNumber
				+ "]";
	}
	
}
