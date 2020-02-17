package com.task.parkingvision;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.task.parkingvision.exception.ParkingSlotEmptyException;
import com.task.parkingvision.exception.ParkingSlotFullException;
import com.task.parkingvision.exception.VechileNotFoundException;
import com.task.parkingvision.model.ParkedVehicle;
import com.task.parkingvision.parkingservice.ParkingService;

public class ParkingServiceTest {

	
	private ParkingService parkingService = new ParkingService();

    // test for the registering car and checking the input list
    @Test
    public void registrationTests(){
        ParkingService.parkedCars.clear();
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2915","white",3));
        assertEquals(3,ParkingService.parkedCars.size());
    }
    
 // test for the checking the exception thrown at time of slot if full
    @Test(expected= ParkingSlotFullException.class)
    public void registrationTestsException() throws ParkingSlotFullException{
        ParkingService.totalSlot = 2;
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2813","white",1));
        parkingService.parkCar();
     
    }
    
 //test for the getting 0 as no slot available
    @Test
    public void testNoSlotNumber(){
        ParkingService.totalSlot = 1;
        ParkingService parkingManage = new ParkingService();
        parkingManage.slots[0]=true;
        assertEquals(0,parkingManage.getSlot());
    }

 

    //for pickup the car from lobby test
    @Test
    public void testPickingCar() throws VechileNotFoundException, ParkingSlotEmptyException {
        ParkingService.totalSlot = 2;
        ParkingService park = new ParkingService();
        ParkingService.parkedCars.clear();
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
        park.pickupCar("KA-07-2913");
        assertEquals(1,ParkingService.parkedCars.size());
    }
//
//    //for pickup the car from lobby test that throws exception for carnot found
    @Test(expected= VechileNotFoundException.class)
    public void testPickingCarNotFound() throws VechileNotFoundException, ParkingSlotEmptyException {
        ParkingService.totalSlot = 2;
        ParkingService park = new ParkingService();
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
       
            park.pickupCar("KA-07-2919");
       
    }
//
//    //for pickup the car from lobby test that throws exception for lobby is empty
    @Test(expected=ParkingSlotEmptyException.class)
    public void testPickingCarFromEmptyLobby() throws VechileNotFoundException, ParkingSlotEmptyException {
        ParkingService.totalSlot = 2;
        ParkingService park = new ParkingService();
        ParkingService.parkedCars.clear();
      
            park.pickupCar("KA-07-2919");
      
    }

//    // test for the getCarsByColour for wrong colours
    @Test(expected= VechileNotFoundException.class)
    public void testgetCarsByColourException() throws VechileNotFoundException{
        ParkingService.totalSlot = 2;
        ParkingService park = new ParkingService();
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
        park.getCarNumberByCarColour("red");
      
    }


    //test for slot number when car found

    @Test(expected= Exception.class)
    public void testgetSlotByCarNumberException() throws Exception {
        ParkingService.totalSlot = 2;
        ParkingService park = new ParkingService();
        ParkingService.parkedCars.clear();
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
        park.getSlotByCarNumber("KA-07-2918");
       
    }

    // test for the getSlotByColour for wrong colours
    @Test(expected= VechileNotFoundException.class)
    public void getSlotsByColourException() throws NullPointerException, VechileNotFoundException{
        ParkingService.totalSlot = 2;
        ParkingService park = new ParkingService();
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2913","blue",1));
        ParkingService.parkedCars.add(new ParkedVehicle("KA-07-2914","green",2));
        
            park.getSlotByCarColour("red");
        
    }




}
