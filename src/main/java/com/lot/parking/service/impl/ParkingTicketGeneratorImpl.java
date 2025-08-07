package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Vehicle;
import com.lot.parking.service.ParkingTicketGenerator;

import java.util.Date;

public class ParkingTicketGeneratorImpl implements ParkingTicketGenerator
{

    @Override
    public ParkingTicket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot)
    {
        return ParkingTicket.builder()
                .setTicketId(parkingSpot.getParkingSpotId() + "#" + vehicle.getVehicleNumber())
                .setSpotId(parkingSpot.getParkingSpotId())
                .setVehicleNumber(vehicle.getVehicleNumber())
                .setEntryTime(new Date())
                .setExitTime(null) // Exit time will be set later
                .setDuration(0) // Duration will be calculated later
                .setAmount(0) // Amount will be calculated later
                .build();
    }

}
