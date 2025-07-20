package com.lot.parking.entities;

import com.lot.parking.utils.FloorStatus;

public class DisplayPanel
{
    private Integer floorNumber;
    private FloorStatus floorStatus;
    
    public DisplayPanel()
    {
        // Default constructor
    }
    public DisplayPanel(Integer floorNumber, FloorStatus floorStatus)
    {
        this.floorNumber = floorNumber;
        this.floorStatus = floorStatus;
    }
    
    public Integer getFloorNumber()
    {
        return floorNumber;
    }
    public void setFloorNumber(Integer floorNumber)
    {
        this.floorNumber = floorNumber;
    }
    public FloorStatus getFloorStatus()
    {
        return floorStatus;
    }
    public void setFloorStatus(FloorStatus floorStatus)
    {
        this.floorStatus = floorStatus;
    }
    

}
