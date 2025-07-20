package com.lot.parking.utils;

public enum FloorStatus
{
    AVAILABLE("Available"),
    FULL("Full"),
    UNDER_MAINTENANCE("Under Maintenance");

    private final String status;

    FloorStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
