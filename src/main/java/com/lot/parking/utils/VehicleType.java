package com.lot.parking.utils;

public enum VehicleType
{
    CAR("Car"),
    TRUCK("Truck"),
    MOTORCYCLE("Motorcycle"),
    BUS("Bus"),
    VAN("Van"),
    ELECTRIC("Electric"),
    BICYCLE("Bicycle");

    private final String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
