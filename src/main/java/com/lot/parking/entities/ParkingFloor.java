package com.lot.parking.entities;

import com.lot.parking.utils.FloorStatus;
import com.lot.parking.utils.ParkingSpotStatus;

import java.util.HashSet;
import java.util.Set;

public class ParkingFloor
{
    private int floorNumber;
    private Set<ParkingSpot> parkingSpots;
    private int totalSpots;
    private int availableSpots;
    private DisplayPanel displayPanel;
    
    public ParkingFloor(int floorNumber, DisplayPanel displayPanel) {
        this.floorNumber = floorNumber;
        this.parkingSpots = new HashSet<>();
        this.displayPanel = displayPanel;
    }
    
    public int getFloorNumber() {
        return floorNumber;
    }
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
    
    public Set<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
    public void addParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
        if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE) {
            availableSpots++;
        }
        totalSpots++;
        displayPanel.setFloorStatus(FloorStatus.AVAILABLE);
    }
    
    public void removeParkingSpot(ParkingSpot parkingSpot) {
        if (this.parkingSpots.remove(parkingSpot)) {
            if (parkingSpot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE) {
                availableSpots--;
            }
            totalSpots--;
            if (totalSpots == 0) {
                displayPanel.setFloorStatus(FloorStatus.UNDER_MAINTENANCE);
            } else if (availableSpots == 0) {
                displayPanel.setFloorStatus(FloorStatus.FULL);
            } else {
                displayPanel.setFloorStatus(FloorStatus.AVAILABLE);
            }
        }
    }
    
    public void updateFloor() {
        availableSpots = 0;
        for (ParkingSpot spot : parkingSpots) {
            if (spot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE) {
                availableSpots++;
            }
        }
    }
    
    public void updateDisplayPanel() {
        if (availableSpots == 0) {
            displayPanel.setFloorStatus(FloorStatus.FULL);
        } else if (totalSpots == 0) {
            displayPanel.setFloorStatus(FloorStatus.UNDER_MAINTENANCE);
        } else {
            displayPanel.setFloorStatus(FloorStatus.AVAILABLE);
        }
    }
    
    public void showDisplayPanel() {
        System.out.println("Floor Number: " + displayPanel.getFloorNumber());
        System.out.println("Floor Status: " + displayPanel.getFloorStatus().getStatus());
        System.out.println("Available Spots: " + availableSpots);
        System.out.println("Total Spots: " + totalSpots);
    }
    
}
