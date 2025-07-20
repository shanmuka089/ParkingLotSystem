package com.lot.parking.utils;

import com.lot.parking.exception.ParkingSystemException;

import java.util.HashMap;
import java.util.Map;

public class VehicleSpotTypeMap
{
    static Map<VehicleType, ParkingSpotType> vehicleSpotMap = new HashMap<>();
    
    static {
        vehicleSpotMap.put(VehicleType.CAR, ParkingSpotType.REGULAR);
        vehicleSpotMap.put(VehicleType.TRUCK, ParkingSpotType.LARGE);
        vehicleSpotMap.put(VehicleType.MOTORCYCLE, ParkingSpotType.MOTORCYCLE);
        vehicleSpotMap.put(VehicleType.BUS, ParkingSpotType.LARGE);
        vehicleSpotMap.put(VehicleType.VAN, ParkingSpotType.REGULAR);
        vehicleSpotMap.put(VehicleType.ELECTRIC, ParkingSpotType.ELECTRIC);
        vehicleSpotMap.put(VehicleType.BICYCLE, ParkingSpotType.COMPACT);
    }
    
    public static ParkingSpotType getParkingSpotType(VehicleType vehicleType) {
        ParkingSpotType parkingSpotType = vehicleSpotMap.get(vehicleType);
        if(parkingSpotType == null) {
            throw new ParkingSystemException("No parking spot type found for vehicle type: " + vehicleType);
        }
        return parkingSpotType;
    }
}
