package com.lot.parking.service;

import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Vehicle;

public interface ParkingTicketGenerator
{
    ParkingTicket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot);
}
