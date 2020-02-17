package com.task.parkingvision;
import java.util.Scanner;

import com.task.parkingvision.exception.ParkingSlotEmptyException;
import com.task.parkingvision.exception.ParkingSlotFullException;
import com.task.parkingvision.exception.VechileNotFoundException;
import com.task.parkingvision.model.ParkedVehicle;
import com.task.parkingvision.parkingservice.IParkingService;
import com.task.parkingvision.parkingservice.ParkingService;
public class ParkingVision {
	
	
	
	public static void main(String[] args) {
		 
		Scanner choice = new Scanner(System.in);
		 createSlots();
		 ParkingService service =new ParkingService();
	while(true) {
		 System.out.println("Please select 1 for parking car");
		 System.out.println("Please select 2 for pick up car");
		 System.out.println("please select 3 to get slots number by car colour ");
		 System.out.println("Please select 4 to get slot number by car number");
		 System.out.println("Please select 5 to get car number by car colour");
		 System.out.println("Please select 6 to Exit");  
		
		
		 Integer userChoice = choice.nextInt();
		
//		 ParkingService service =new ParkingService();
		 
		switch(userChoice) {
		  case 1:	
			  try {
				  service.parkCar();
              } catch (ParkingSlotFullException p) {
                  System.out.println(p.getMessage());
              }
			 
		    break;
		  case 2:
			  System.out.println("please enter your car number");
			  Scanner carChoice = new Scanner(System.in);
			  String carNumber = carChoice.nextLine();
			  try {
				  service.pickupCar(carNumber);
              } catch (VechileNotFoundException e) {
                  System.out.println(e.getMessage());
              } catch (ParkingSlotEmptyException pe) {
                  System.out.println(pe.getMessage());
              }
		     
		    break;
		    
		  case 3:
			  Scanner carColourChoice = new Scanner(System.in);
			  System.out.println("please enter car colour to get slot numbers");
			  String carColourcarColourChoice = carColourChoice.nextLine();
			  try {
				  service.getSlotByCarColour(carColourcarColourChoice);
              } catch (VechileNotFoundException e) {
                  System.out.println(e.getMessage());
              } catch (Exception  ex){
                  System.out.println(ex.getMessage());
              }
		    
			    break;
			    
		  case 4:
			  System.out.println("please enter car number to get slot number");
			  Scanner NumberPlate = new Scanner(System.in);
			  String carNumberPlate = NumberPlate.nextLine();
			  System.out.println("carNumberPlate"+carNumberPlate);
			  try {
				  service.getSlotByCarNumber(carNumberPlate);
              } catch (VechileNotFoundException e) {
                  System.out.println(e.getMessage());
              } catch (Exception e) {
                  System.out.println(e.getMessage());
              }
		    
			  	break;
			  	
		  case 5:
			  Scanner carColours = new Scanner(System.in);
			  System.out.println("please enter car colour to get car numbers");
			  String carColour = carColours.nextLine();
			try {
            	  service.getCarNumberByCarColour(carColour);
              } catch (VechileNotFoundException e) {
                  System.out.println(e.getMessage());
              } catch (Exception e) {
                  System.out.println(e.getMessage());
              }
		    
              break;
              
		 case 6:
			  System.exit(0);
			  
		  default:
			  System.out.println("Please enter a valid number");
		}
	}	

	}
	public static int createSlots() {
		 Scanner choice = new Scanner(System.in);
		System.out.println("Please enter number of slots");
		 Integer totalSlot = choice.nextInt();
		 ParkingService.totalSlot = totalSlot;
		 return totalSlot;
	}

}
