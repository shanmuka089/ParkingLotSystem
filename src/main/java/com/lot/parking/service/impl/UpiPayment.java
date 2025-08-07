package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Payment;
import com.lot.parking.service.PaymentChannel;

import java.util.logging.Logger;

public class UpiPayment implements PaymentChannel
{
    static final Logger logger = Logger.getLogger(UpiPayment.class.getName());

    @Override
    public void processPayment(ParkingTicket parkingTicket, Payment payment)
    {
        logger.info("Processing UPI payment for ticket ID: " + parkingTicket.getTicketId());
        System.out.println(payment);
    }

}
