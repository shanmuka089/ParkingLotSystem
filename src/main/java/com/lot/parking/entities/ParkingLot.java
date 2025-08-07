package com.lot.parking.entities;

import com.lot.parking.service.EntryGate;
import com.lot.parking.service.ExitGate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot
{
    
    private String name;

    private String location;
    
    private Map<Integer, EntryGate> entryGates;
    private Map<Integer, ExitGate> exitGates;
    private Map<Integer, ParkingFloor> parkingFloors;
    
    public ParkingLot(String name, String location, Map<Integer, EntryGate> entryGates, Map<Integer, ExitGate> exitGates) {
        this.name = name;
        this.location = location; 
        this.entryGates = entryGates;
        this.exitGates = exitGates;
        this.parkingFloors = new ConcurrentHashMap<>();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Map<Integer, ParkingFloor> getParkingFloors() {
        
        return Collections.unmodifiableMap(parkingFloors);
    }
    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.put(parkingFloor.getFloorNumber(), parkingFloor);
    }
    public void removeParkingFloor(int floorNumber) {
        this.parkingFloors.remove(floorNumber);
    }
    public ParkingFloor getParkingFloor(int floorNumber) {
        return this.parkingFloors.get(floorNumber);
    }
    
    public EntryGate getEntryGate(int gateNumber) {
        return entryGates.get(gateNumber);
    }
    
    public ExitGate getExitGate(int gateNumber) {
        return exitGates.get(gateNumber);
    }

}
