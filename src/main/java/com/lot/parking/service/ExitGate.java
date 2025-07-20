package com.lot.parking.service;

import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Payment;

public abstract class ExitGate
{
    protected CostCalculator costCalculator;
    protected PaymentChannel paymentChannel;
    
    public ExitGate(CostCalculator costCalculator, PaymentChannel paymentChannel) {
        this.costCalculator = costCalculator;
        this.paymentChannel = paymentChannel;
    }
    
    public abstract void calculateCost(ParkingTicket parkingTicket);
    public abstract void processPayment(ParkingTicket parkingTicket, Payment payment);
}
