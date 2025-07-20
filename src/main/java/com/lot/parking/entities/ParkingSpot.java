package com.lot.parking.entities;

import com.lot.parking.utils.ParkingSpotStatus;
import com.lot.parking.utils.ParkingSpotType;

public class ParkingSpot
{
    private Integer parkingSpotId;
    private Integer floorNumber;
    private Vehicle vehicle;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingSpotType parkingSpotType;
    
    public ParkingSpot()
    {
        // Default constructor
    }
    public ParkingSpot(Integer parkingSpotId, Integer floorNumber, ParkingSpotStatus parkingSpotStatus, ParkingSpotType parkingSpotType)
    {
        this.parkingSpotId = parkingSpotId;
        this.floorNumber = floorNumber;
        this.parkingSpotStatus = parkingSpotStatus;
        this.parkingSpotType = parkingSpotType;
    }
    
    public Integer getFloorNumber()
    {
        return floorNumber;
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
    
    public void parkVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.parkingSpotStatus = ParkingSpotStatus.OCCUPIED;
    }
    
    public void unParkVehicle()
    {
        this.vehicle = null;
        this.parkingSpotStatus = ParkingSpotStatus.AVAILABLE;
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
        return "ParkingSpot [parkingSpotId=" + parkingSpotId + ", floorNumber=" + floorNumber + ", vehicle=" + vehicleDetails
                + ", parkingSpotStatus=" + parkingSpotStatus + ", parkingSpotType=" + parkingSpotType + "]";
    }
}
