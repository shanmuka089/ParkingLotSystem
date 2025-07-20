package com.lot.parking.utils;

public enum ParkingSpotStatus
{
    AVAILABLE("Available"),
    OCCUPIED("Occupied"),
    RESERVED("Reserved"),
    MAINTENANCE("Maintenance");
    

    private final String status;

    ParkingSpotStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
