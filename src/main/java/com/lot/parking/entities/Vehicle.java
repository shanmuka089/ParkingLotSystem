package com.lot.parking.entities;

import com.lot.parking.utils.VehicleType;

public class Vehicle
{
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleModel;
    
    public Vehicle()
    {
        // Default constructor
    }
    
    public Vehicle(VehicleType vehicleType, String vehicleNumber, String vehicleModel)
    {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.vehicleModel = vehicleModel;
    }
    
    public VehicleType getVehicleType()
    {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType)
    {
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber()
    {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber)
    {
        this.vehicleNumber = vehicleNumber;
    }
    public String getVehicleModel()
    {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel)
    {
        this.vehicleModel = vehicleModel;
    }
    @Override
    public String toString()
    {
        return "Vehicle [vehicleType=" + vehicleType.getType() + ", vehicleNumber=" + vehicleNumber + ", vehicleModel="
                + vehicleModel + "]";
    }
    
}
