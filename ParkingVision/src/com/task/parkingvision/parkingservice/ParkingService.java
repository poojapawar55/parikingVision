package com.task.parkingvision.parkingservice;

import java.util.HashSet;
import java.util.Scanner;

import com.task.parkingvision.ParkingVision;
import com.task.parkingvision.exception.ParkingSlotEmptyException;
import com.task.parkingvision.exception.ParkingSlotFullException;
import com.task.parkingvision.exception.VechileNotFoundException;
import com.task.parkingvision.model.ParkedVehicle;

public class ParkingService implements IParkingService {
	public static HashSet<ParkedVehicle> parkedCars = new HashSet<ParkedVehicle>();
	public static int totalSlot;
	public boolean[] slots = new boolean[totalSlot];
	Scanner choice = new Scanner(System.in);
	
    //1.function for registration of car
	@Override
	public void parkCar() throws ParkingSlotFullException{
		try {
			if (parkedCars.size() < totalSlot) {
		  System.out.println("please enter your car number");
		  String carNumber = choice.nextLine();
		  
		  System.out.println("please enter your car colour");
		  String carColour = choice.nextLine();
		 
		System.out.println("totalSlot"+ totalSlot);
		
		for (int slot=0; slot<=totalSlot-1; slot++) {
			
			if(slots[slot]==false) {
				slots[slot]=true;
				parkedCars.add(new ParkedVehicle(carNumber,carColour,slot+1));
				 break;
			}
			
		}
		for (int slot=0; slot<=totalSlot-1; slot++) {
			System.out.println("slots"+slots[slot]);
		}
		
		for (ParkedVehicle parkedVehicle : parkedCars) {
			System.out.println("parkedVehicle"+parkedVehicle);
		}

			} else {
				throw new ParkingSlotFullException("Sorry, there is no empty parking slot");
			}
		} catch (Exception ee) {
			throw new ParkingSlotFullException("sorry,there is no empty parking slot");
		}
		}
		

  //2.function for pickup car
	@Override
	public void pickupCar(String carNumber) throws VechileNotFoundException, ParkingSlotEmptyException {
		try {
			if (parkedCars.size() > 0) {
				System.out.println(parkedCars.toString());
		  ParkedVehicle p = new ParkedVehicle();
		  for (ParkedVehicle parkedVehicle : parkedCars) {
			if(parkedVehicle.getCarNumber().equals(carNumber)) {
				 p=parkedVehicle;
				 System.out.println(";;;"+parkedCars.toString());
				 
			}
		}
		  if(p.getCarNumber()==null) {
				throw new VechileNotFoundException("Sorry!! No car found in lobby");
			}
		  parkedCars.remove(p);
		  slots[(p.getSlotNumber())-1]=false;
			for (int slot=0; slot<=totalSlot-1; slot++) {
				System.out.println("slots:"+slots[slot]);
			}
			
			for (ParkedVehicle parkedVehicle : parkedCars) {
				System.out.println("parkedVehicle"+parkedVehicle);
			}
			} else {
				throw new ParkingSlotEmptyException("Oops there is no car parking in the lobby");
			}
		} catch (VechileNotFoundException ee) {
			throw new VechileNotFoundException(ee.getMessage());
		} catch (ParkingSlotEmptyException pe) {
			throw new ParkingSlotEmptyException(pe.getMessage());
		}
	}
	
	//3.function for get slot numbers by car colour
	@Override
	public void getSlotByCarColour(String carColour) throws VechileNotFoundException, NullPointerException {
try {
			
			if (parkedCars.size() > 0) {
		
		  System.out.println("Slots number for"+carColour+":");
		  ParkedVehicle p = new ParkedVehicle();
		  for (ParkedVehicle parkedVehicle : parkedCars) {
				if(parkedVehicle.getCarColour().equals(carColour)) {
					 p=parkedVehicle;
					System.out.println(parkedVehicle.getSlotNumber());
				}
			
	  }
		  if(p.getCarColour()== null) {
			  throw new VechileNotFoundException("No Car with this colour in parking lot");
			} 
		}else {
			throw new NullPointerException("No Car in parking lot");
		} 
		
	  } catch (VechileNotFoundException ee) {
			throw new VechileNotFoundException(ee.getMessage());
		}
	
	catch (Exception ee){
		throw new NullPointerException("There is no Car in parking lot");
	}
	
	
}
//4.function for get slot number by car number
	@Override
	public void getSlotByCarNumber(String carNumberPlate)throws VechileNotFoundException,NullPointerException  {
		try {
			
			if (parkedCars.size() > 0) {
		
		  System.out.println("Slots number for"+carNumberPlate+"is:");
		  ParkedVehicle p = new ParkedVehicle();
		  for (ParkedVehicle parkedVehicle : parkedCars) {
				if(parkedVehicle.getCarNumber().equals(carNumberPlate)) {
					p=parkedVehicle;
					System.out.println(parkedVehicle.getSlotNumber());
				} 
				
				
		  }
		  if(p.getCarNumber()==null) {
			  throw new VechileNotFoundException("No Car with this number in parking lot");
			} 
			
		 
			}else {
				throw new NullPointerException("No Car parking lot");
			} 
			
		  } catch (VechileNotFoundException ee) {
				throw new VechileNotFoundException(ee.getMessage());
			}
		
		catch (Exception ee){
			throw new NullPointerException("There is no Car in parking lot");
		}
		
		
	}

	//5.function for get car numbers by car colour
	@Override
	public void getCarNumberByCarColour(String carColour) throws VechileNotFoundException {
		try {
			if (parkedCars.size() > 0) {
		
		  System.out.println("car numbers for"+carColour+":");
		  ParkedVehicle p = new ParkedVehicle();
		  for (ParkedVehicle parkedVehicle : parkedCars) {
				if(parkedVehicle.getCarColour().equals(carColour)) {
					p=parkedVehicle;
					System.out.println(parkedVehicle.getCarNumber());
				}
		  }
		  if(p.getCarColour()==null) {
			  throw new VechileNotFoundException("No Car with this colour was found in parking lot");
			}
		  
			}else {
				throw new NullPointerException("No Car parking lot");
			} 
			}catch (VechileNotFoundException ee) {
				throw new VechileNotFoundException(ee.getMessage());
			}
		catch (Exception ee){
			throw new NullPointerException("There is no Car in parking lot");
		}
		
		
	}
	public int getSlot() {
//		System.out.println("sloztsize"+slotSize);
		for (int i = 0; i < totalSlot; i++) {
			if (!slots[i]) {
				return i + 1;
			}
		}
		return 0;
	}


	
}
