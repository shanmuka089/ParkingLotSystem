package com.lot.parking.service;

import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Payment;

public interface PaymentChannel
{
    void processPayment(ParkingTicket parkingTicket, Payment payment);
}
