package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingFloor;
import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.Vehicle;
import com.lot.parking.exception.ParkingSystemException;
import com.lot.parking.service.AllocateParkingSpot;
import com.lot.parking.utils.ParkingSpotStatus;
import com.lot.parking.utils.VehicleSpotTypeMap;

import java.util.Map;

public class AllocateParkingSpotImpl implements AllocateParkingSpot
{

    @Override
    public synchronized ParkingSpot allocateParkingSpot(Vehicle vehicle, Map<Integer, ParkingFloor> parkingFloors)
    {
        if (vehicle == null || parkingFloors == null || parkingFloors.isEmpty()) {
            throw new ParkingSystemException("Invalid input: Vehicle or parking floors cannot be null or empty.");
        }
        
        // check the spots in each floor if it finds a spot then return it
        return parkingFloors.values().stream().flatMap(floor -> floor.getParkingSpots().stream())
                .filter(parkingSpot -> parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE)
                .filter(parkingSpot -> parkingSpot.getParkingSpotType() == VehicleSpotTypeMap.getParkingSpotType(vehicle.getVehicleType()))
                .findFirst()
                .orElse(null);
    }

}
