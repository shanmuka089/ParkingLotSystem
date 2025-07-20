package com.lot.parking.service;

import com.lot.parking.entities.ParkingTicket;

public interface CostCalculator
{
    double calculateCost(ParkingTicket parkingTicket);
}
