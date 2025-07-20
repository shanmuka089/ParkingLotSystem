package com.lot.parking.service;

import com.lot.parking.entities.ParkingFloor;
import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Vehicle;

import java.util.Map;

public abstract class EntryGate
{
    protected ParkingTicketGenerator parkingTicketGenerator;
    protected AllocateParkingSpot allocateParkingSpot;
    
    public EntryGate(ParkingTicketGenerator parkingTicketGenerator, AllocateParkingSpot allocateParkingSpot) {
        this.parkingTicketGenerator = parkingTicketGenerator;
        this.allocateParkingSpot = allocateParkingSpot;
    }
    
    public abstract ParkingSpot allocateParkingSpot(Vehicle vehicle, Map<Integer, ParkingFloor> parkingFloors);
    public abstract ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot);
}
