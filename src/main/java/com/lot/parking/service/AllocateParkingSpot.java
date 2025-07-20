package com.lot.parking.service;

import com.lot.parking.entities.ParkingFloor;
import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.Vehicle;

import java.util.Map;

public interface AllocateParkingSpot
{
    ParkingSpot allocateParkingSpot(Vehicle vehicle, Map<Integer, ParkingFloor> parkingFloors);
    
}
