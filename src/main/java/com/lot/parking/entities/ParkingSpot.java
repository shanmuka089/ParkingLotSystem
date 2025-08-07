package com.lot.parking.entities;

import com.lot.parking.utils.ParkingSpotStatus;
import com.lot.parking.utils.ParkingSpotType;

import java.util.logging.Logger;

public class ParkingSpot
{
    static final Logger logger = Logger.getLogger(ParkingSpot.class.getName());
    private Integer parkingSpotId;
    private Vehicle vehicle;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingSpotType parkingSpotType;
    
    public ParkingSpot()
    {
        // Default constructor
    }
    public ParkingSpot(Integer parkingSpotId, ParkingSpotStatus parkingSpotStatus, ParkingSpotType parkingSpotType)
    {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotStatus = parkingSpotStatus;
        this.parkingSpotType = parkingSpotType;
    }
    
    
    public Integer getParkingSpotId()
    {
        return parkingSpotId;
    }
    public void setParkingSpotId(Integer parkingSpotId)
    {
        this.parkingSpotId = parkingSpotId;
    }
    
    public ParkingSpotStatus getParkingSpotStatus()
    {
        return parkingSpotStatus;
    }
    
    public ParkingSpotType getParkingSpotType()
    {
        return parkingSpotType;
    }
    
    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus)
    {
        this.parkingSpotStatus = parkingSpotStatus;
    }
    
    public void parkVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.parkingSpotStatus = ParkingSpotStatus.OCCUPIED;

        logger.info("Vehicle parked in spot ID: " + parkingSpotId + ", Vehicle Details: " + vehicle);
    }
    
    public void unParkVehicle()
    {
        this.vehicle = null;
        this.parkingSpotStatus = ParkingSpotStatus.AVAILABLE;

        logger.info("Vehicle unparked from spot ID: " + parkingSpotId);
    }
    
    public void setParkingSpotType(ParkingSpotType parkingSpotType)
    {
        this.parkingSpotType = parkingSpotType;
    }
    
    /**
     * Returns a string representation of the ParkingSpot object.
     * 
     * @return A string containing the parking spot ID, vehicle details, status, and type.
     */
    @Override
    public String toString()
    {
        String vehicleDetails = (vehicle != null) ? vehicle.toString() : "No Vehicle";
        return "ParkingSpot [parkingSpotId=" + parkingSpotId + ", vehicle=" + vehicleDetails
                + ", parkingSpotStatus=" + parkingSpotStatus + ", parkingSpotType=" + parkingSpotType + "]";
    }
}
