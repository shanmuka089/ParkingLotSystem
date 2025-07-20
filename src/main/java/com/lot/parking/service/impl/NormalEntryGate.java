package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingFloor;
import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Vehicle;
import com.lot.parking.service.AllocateParkingSpot;
import com.lot.parking.service.EntryGate;
import com.lot.parking.service.ParkingTicketGenerator;

import java.util.Map;

public class NormalEntryGate extends EntryGate
{
    public NormalEntryGate(ParkingTicketGenerator parkingTicketGenerator, AllocateParkingSpot allocateParkingSpot) {
        super(parkingTicketGenerator, allocateParkingSpot);
    }
    public ParkingSpot allocateParkingSpot(Vehicle vehicle, Map<Integer, ParkingFloor> parkingFloors) {
        return allocateParkingSpot.allocateParkingSpot(vehicle, parkingFloors);
    }

    public ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return parkingTicketGenerator.generateTicket(vehicle, parkingSpot);
    }
}
