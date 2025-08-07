package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.entities.Payment;
import com.lot.parking.service.CostCalculator;
import com.lot.parking.service.ExitGate;
import com.lot.parking.service.PaymentChannel;
import com.lot.parking.service.PaymentChannelFactory;

public class VipExitGate extends ExitGate
{
    public VipExitGate(CostCalculator costCalculator, PaymentChannel paymentChannel)
    {
        super(costCalculator, paymentChannel);
    }

    @Override
    public void calculateCost(ParkingTicket parkingTicket)
    {
        this.costCalculator.calculateCost(parkingTicket);
    }

    @Override
    public void processPayment(ParkingTicket parkingTicket, Payment payment)
    {
        paymentChannel = PaymentChannelFactory.getPaymentChannel(payment.getPaymentMode());
        this.paymentChannel.processPayment(parkingTicket, payment);
    }
}
