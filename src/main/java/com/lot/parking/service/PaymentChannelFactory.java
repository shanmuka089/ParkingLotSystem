package com.lot.parking.service;

import com.lot.parking.exception.ParkingSystemException;
import com.lot.parking.service.impl.CreditCardPayment;
import com.lot.parking.service.impl.UpiPayment;

public class PaymentChannelFactory
{
    public static PaymentChannel getPaymentChannel(String paymentMode) {
        if (paymentMode == null || paymentMode.isEmpty()) {
            throw new IllegalArgumentException("Payment channel type cannot be null or empty");
        }
        
        switch (paymentMode.toLowerCase()) {
            case "upi":
                return new UpiPayment();
            case "creditcard":
                return new CreditCardPayment();
            default:
                throw new ParkingSystemException("Unknown payment mode type: " + paymentMode);
        }
    }

}
