package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingFloor;
import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Vehicle;
import com.lot.parking.service.AllocateParkingSpot;
import com.lot.parking.service.EntryGate;
import com.lot.parking.service.ParkingTicketGenerator;

import java.util.Map;

public class VipEntryGate extends EntryGate
{

    public VipEntryGate(ParkingTicketGenerator parkingTicketGenerator, AllocateParkingSpot allocateParkingSpot)
    {
        super(parkingTicketGenerator, allocateParkingSpot);
    }

    @Override
    public ParkingSpot allocateParkingSpot(Vehicle vehicle, Map<Integer, ParkingFloor> parkingFloors)
    {
       return this.allocateParkingSpot.allocateParkingSpot(vehicle, parkingFloors);
    }

    @Override
    public ParkingTicket generateParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot)
    {
        return this.parkingTicketGenerator.generateTicket(vehicle, parkingSpot);
    }

}
