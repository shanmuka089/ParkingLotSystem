package com.lot.parking.entities;

import java.util.Date;

public class ParkingTicket
{
    private final String ticketId;
    
    private final Integer spotId;
    private final String vehicleNumber;
    private final Integer floorNumber;
    private final Date entryTime;
    private Date exitTime;
    private double duration;
    
    private double amount;

    public String getTicketId()
    {

        return ticketId;
    }

    public Integer getSpotId()
    {

        return spotId;
    }

    public String getVehicleNumber()
    {

        return vehicleNumber;
    }

    public Integer getFloorNumber()
    {

        return floorNumber;
    }

    public Date getEntryTime()
    {

        return entryTime;
    }

    public Date getExitTime()
    {

        return exitTime;
    }

    public double getDuration()
    {

        return duration;
    }

    public double getAmount()
    {

        return amount;
    }

    public void setExitTime(Date exitTime)
    {

        this.exitTime = exitTime;
    }

    public void setDuration(double duration)
    {

        this.duration = duration;
    }

    public void setAmount(double amount)
    {

        this.amount = amount;
    }

    public ParkingTicket(String ticketId, Integer spotId, String vehicleNumber, Integer floorNumber, Date entryTime)
    {
        this.ticketId = ticketId;
        this.spotId = spotId;
        this.vehicleNumber = vehicleNumber;
        this.floorNumber = floorNumber;
        this.entryTime = entryTime;
    }
    
    public static ParkingTicketBuilder builder() {
        return new ParkingTicketBuilder();
    }
    
    public static class ParkingTicketBuilder {
        private String ticketId;
        private Integer spotId;
        private String vehicleNumber;
        private Integer floorNumber;
        private Date entryTime;
        private Date exitTime;
        private double duration;
        private double amount;

        public ParkingTicketBuilder setTicketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public ParkingTicketBuilder setSpotId(Integer spotId) {
            this.spotId = spotId;
            return this;
        }

        public ParkingTicketBuilder setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public ParkingTicketBuilder setFloorNumber(Integer floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        public ParkingTicketBuilder setEntryTime(Date entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public ParkingTicketBuilder setExitTime(Date exitTime) {
            this.exitTime = exitTime;
            return this;
        }

        public ParkingTicketBuilder setDuration(double duration) {
            this.duration = duration;
            return this;
        }

        public ParkingTicketBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public ParkingTicket build() {
            ParkingTicket ticket = new ParkingTicket(ticketId, spotId, vehicleNumber, floorNumber, entryTime);
            ticket.exitTime = exitTime;
            ticket.duration = duration;
            ticket.amount = amount;
            return ticket;
        }
    }
}
