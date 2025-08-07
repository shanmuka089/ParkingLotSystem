package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingFloor;
import com.lot.parking.entities.ParkingSpot;
import com.lot.parking.entities.Vehicle;
import com.lot.parking.exception.ParkingSystemException;
import com.lot.parking.service.AllocateParkingSpot;
import com.lot.parking.utils.ParkingSpotStatus;
import com.lot.parking.utils.VehicleSpotTypeMap;

import java.util.Map;
import java.util.logging.Logger;

public class AllocateParkingSpotImpl implements AllocateParkingSpot
{

    static final Logger logger = Logger.getLogger(AllocateParkingSpotImpl.class.getName());

    @Override
    public synchronized ParkingSpot allocateParkingSpot(Vehicle vehicle, Map<Integer, ParkingFloor> parkingFloors)
    {
        if (vehicle == null || parkingFloors == null || parkingFloors.isEmpty()) {
            logger.warning("Invalid input: Vehicle or parking floors cannot be null or empty.");
            throw new ParkingSystemException("Invalid input: Parking floors cannot be null or empty.");
        }
        
        // check the spots in each floor if it finds a spot then return it
        ParkingSpot pSpot = parkingFloors.values().stream().flatMap(floor -> floor.getParkingSpots().stream())
                .filter(parkingSpot -> parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE)
                .filter(parkingSpot -> parkingSpot.getParkingSpotType() == VehicleSpotTypeMap.getParkingSpotType(vehicle.getVehicleType()))
                .findFirst()
                .orElseThrow(() -> new ParkingSystemException("No available parking spot found for vehicle type: " + vehicle.getVehicleType()));
        pSpot.setParkingSpotStatus(ParkingSpotStatus.RESERVED);
        logger.info("Allocated parking spot: " + pSpot.getParkingSpotId() + " for vehicle: " + vehicle.getVehicleNumber());
        
        return pSpot;
    }

}
