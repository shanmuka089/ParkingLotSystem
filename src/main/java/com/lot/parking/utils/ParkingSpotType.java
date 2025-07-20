package com.lot.parking.utils;

public enum ParkingSpotType
{
    COMPACT("Compact"),
    REGULAR("Regular"),
    LARGE("Large"),
    HANDICAPPED("Handicapped"),
    MOTORCYCLE("Motorcycle"),
    ELECTRIC("Electric");

    private final String type;

    ParkingSpotType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
