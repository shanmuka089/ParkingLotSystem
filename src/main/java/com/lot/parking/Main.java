package com.lot.parking;

import com.lot.parking.entities.*;
import com.lot.parking.exception.ParkingSystemException;
import com.lot.parking.service.EntryGate;
import com.lot.parking.service.ExitGate;
import com.lot.parking.service.impl.*;
import com.lot.parking.utils.FloorStatus;
import com.lot.parking.utils.ParkingSpotStatus;
import com.lot.parking.utils.ParkingSpotType;
import com.lot.parking.utils.VehicleType;

import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

public class Main
{
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args)
    {

        ParkingLot parkingLot = initializeParkingLot();

        logger.info("Initializing Parking Lot with 3 floors and 5 parking spots each.");
        ParkingFloor parkingFloor1 = new ParkingFloor(1, new DisplayPanel(1, FloorStatus.AVAILABLE));
        parkingFloor1.addParkingSpot(new ParkingSpot(101, ParkingSpotStatus.AVAILABLE, ParkingSpotType.LARGE));
        parkingFloor1.addParkingSpot(new ParkingSpot(102, ParkingSpotStatus.AVAILABLE, ParkingSpotType.ELECTRIC));
        parkingFloor1.addParkingSpot(new ParkingSpot(103, ParkingSpotStatus.AVAILABLE, ParkingSpotType.REGULAR));
        parkingFloor1.addParkingSpot(new ParkingSpot(104, ParkingSpotStatus.AVAILABLE, ParkingSpotType.COMPACT));
        parkingFloor1.addParkingSpot(new ParkingSpot(105, ParkingSpotStatus.AVAILABLE, ParkingSpotType.REGULAR));
        
        ParkingFloor parkingFloor2 = new ParkingFloor(2, new DisplayPanel(1, FloorStatus.AVAILABLE));
        parkingFloor2.addParkingSpot(new ParkingSpot(201, ParkingSpotStatus.AVAILABLE, ParkingSpotType.LARGE));
        parkingFloor2.addParkingSpot(new ParkingSpot(202, ParkingSpotStatus.AVAILABLE, ParkingSpotType.ELECTRIC));
        parkingFloor2.addParkingSpot(new ParkingSpot(203, ParkingSpotStatus.AVAILABLE, ParkingSpotType.MOTORCYCLE));
        parkingFloor2.addParkingSpot(new ParkingSpot(204, ParkingSpotStatus.AVAILABLE, ParkingSpotType.REGULAR));
        parkingFloor2.addParkingSpot(new ParkingSpot(205, ParkingSpotStatus.AVAILABLE, ParkingSpotType.COMPACT));
        
        ParkingFloor parkingFloor3 = new ParkingFloor(3, new DisplayPanel(1, FloorStatus.AVAILABLE));
        parkingFloor3.addParkingSpot(new ParkingSpot(301, ParkingSpotStatus.AVAILABLE, ParkingSpotType.LARGE));
        parkingFloor3.addParkingSpot(new ParkingSpot(302, ParkingSpotStatus.AVAILABLE, ParkingSpotType.ELECTRIC));
        parkingFloor3.addParkingSpot(new ParkingSpot(303, ParkingSpotStatus.AVAILABLE, ParkingSpotType.MOTORCYCLE));
        parkingFloor3.addParkingSpot(new ParkingSpot(304, ParkingSpotStatus.AVAILABLE, ParkingSpotType.REGULAR));
        parkingFloor3.addParkingSpot(new ParkingSpot(305, ParkingSpotStatus.AVAILABLE, ParkingSpotType.COMPACT));
        
        logger.info("Adding parking floors to the parking lot.");
        parkingLot.addParkingFloor(parkingFloor1);
        parkingLot.addParkingFloor(parkingFloor2);
        parkingLot.addParkingFloor(parkingFloor3);
        
        logger.info(parkingLot.getName()+" at "+parkingLot.getLocation()+" initialized with "+parkingLot.getParkingFloors().size()+" floors and "+parkingFloor1.getParkingSpots().size()+" parking spots each.");

        logger.info("Creating vehicles for parking.");
        Vehicle vehicle1 = new Vehicle(VehicleType.ELECTRIC, "KA01AB1234", "SUV");
        Vehicle vehicle2 = new Vehicle(VehicleType.MOTORCYCLE, "KA01AB1235", "SUV");
        Vehicle vehicle3 = new Vehicle(VehicleType.CAR, "KA01AB1236", "SUV");
        Vehicle vehicle4 = new Vehicle(VehicleType.ELECTRIC, "KA01AB1634", "SUV");
        Vehicle vehicle5 = new Vehicle(VehicleType.ELECTRIC, "KA01AB1434", "SUV");
        Vehicle vehicle6 = new Vehicle(VehicleType.ELECTRIC, "KA01AB1934", "SUV");
        Vehicle vehicle7 = new Vehicle(VehicleType.MOTORCYCLE, "AP01AB1235", "SUV");
        Vehicle vehicle8 = new Vehicle(VehicleType.CAR, "AP01AB1236", "SUV");
        Vehicle vehicle9 = new Vehicle(VehicleType.CAR, "TS01AB1934", "SUV");

        logger.info("Allocating spots to vehicles in the parking lot.");
        
        EntryGate entryGate1 = parkingLot.getEntryGate(1);
        logger.info("Vehicles entering from Entry Gate 1.");
        
        ParkingSpot allocatedSpot1 = entryGate1.allocateParkingSpot(vehicle1, parkingLot.getParkingFloors());
        ParkingTicket ticket1 = entryGate1.generateParkingTicket(vehicle1, allocatedSpot1);
        
        ParkingSpot allocatedSpot2 = entryGate1.allocateParkingSpot(vehicle2, parkingLot.getParkingFloors());
        ParkingTicket ticket2 = entryGate1.generateParkingTicket(vehicle2, allocatedSpot2);
        

        ParkingSpot allocatedSpot3 = entryGate1.allocateParkingSpot(vehicle3, parkingLot.getParkingFloors());
        ParkingTicket ticket3 = entryGate1.generateParkingTicket(vehicle3, allocatedSpot3);
        

        ParkingSpot allocatedSpot4 = entryGate1.allocateParkingSpot(vehicle4, parkingLot.getParkingFloors());
        ParkingTicket ticket4 = entryGate1.generateParkingTicket(vehicle4, allocatedSpot4);
        

        ParkingSpot allocatedSpot5 = entryGate1.allocateParkingSpot(vehicle5, parkingLot.getParkingFloors());
        ParkingTicket ticket5 = entryGate1.generateParkingTicket(vehicle5, allocatedSpot5);

        EntryGate entryGate2 = parkingLot.getEntryGate(2);
        logger.info("Vehicles entering from Entry Gate 2.");

        try {
            ParkingSpot allocatedSpot6 = entryGate2.allocateParkingSpot(vehicle6, parkingLot.getParkingFloors());
            ParkingTicket ticket6 = entryGate2.generateParkingTicket(vehicle6, allocatedSpot6);
        } catch(ParkingSystemException e) {
            logger.warning("Failed to allocate parking spot for vehicle6: " + e.getMessage());
        }
        

        ParkingSpot allocatedSpot7 = entryGate2.allocateParkingSpot(vehicle7, parkingLot.getParkingFloors());
        ParkingTicket ticket7 = entryGate2.generateParkingTicket(vehicle7, allocatedSpot7);
        

        ParkingSpot allocatedSpot8 = entryGate2.allocateParkingSpot(vehicle8, parkingLot.getParkingFloors());
        ParkingTicket ticket8 = entryGate2.generateParkingTicket(vehicle8, allocatedSpot8);
        

        ParkingSpot allocatedSpot9 = entryGate2.allocateParkingSpot(vehicle9, parkingLot.getParkingFloors());
        ParkingTicket ticket9 = entryGate2.generateParkingTicket(vehicle9, allocatedSpot9);
        
        logger.info("Parking the vehicles in parking spot.");
        allocatedSpot1.parkVehicle(vehicle1);
        allocatedSpot2.parkVehicle(vehicle2);
        allocatedSpot3.parkVehicle(vehicle3);
        allocatedSpot4.parkVehicle(vehicle4);
        allocatedSpot5.parkVehicle(vehicle5);
        allocatedSpot7.parkVehicle(vehicle7);
        allocatedSpot8.parkVehicle(vehicle8);
        allocatedSpot9.parkVehicle(vehicle9);
        
        logger.info("Unparking vehicle1 from parking spot1.");
        allocatedSpot1.unParkVehicle();
        
        logger.info("Reallocating parking spot for vehicle6 after unparking vehicle1.");
        ParkingSpot allocatedSpot6 = entryGate2.allocateParkingSpot(vehicle6, parkingLot.getParkingFloors());
        ParkingTicket ticket6 = entryGate2.generateParkingTicket(vehicle6, allocatedSpot6);
        allocatedSpot6.parkVehicle(vehicle6);
        
        ExitGate exitGate = parkingLot.getExitGate(1);
        logger.info("Caluculating cost for vehicle1 at Exit Gate 1.");
        exitGate.calculateCost(ticket1);
        //generating transaction id
        Random random = new Random();
        int transactionId = random.nextInt(1000000);
        logger.info("Processing payment for vehicle1 with transaction ID: " + transactionId);
        exitGate.processPayment(ticket1, new Payment("UPI", 100.0, transactionId));
        
        logger.info("Vehicle1 exited the parking lot with ticket ID: " + ticket1.getTicketId());
    }

    private static ParkingLot initializeParkingLot()
    {
        
        logger.info("Initializing Entry and Exit Gates for the Parking Lot.");
        Map<Integer, EntryGate> entryGates = Map.of(
                1, new NormalEntryGate(new ParkingTicketGeneratorImpl(), new AllocateParkingSpotImpl()),
                2, new VipEntryGate(new ParkingTicketGeneratorImpl(), new AllocateParkingSpotImpl())
        );

        Map<Integer, ExitGate> exitGates = Map.of(
                1, new NormalExitGate(new CostCalculatorImpl(), null),
                2, new VipExitGate(new CostCalculatorImpl(), null)
        );

        ParkingLot parkingLot = new ParkingLot("City Center Parking", "Downtown", entryGates, exitGates);
        return parkingLot;
    }

}










