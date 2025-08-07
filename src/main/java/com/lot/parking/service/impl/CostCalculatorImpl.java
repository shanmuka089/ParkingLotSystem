package com.lot.parking.service.impl;

import com.lot.parking.entities.ParkingTicket;
import com.lot.parking.service.CostCalculator;

import java.util.Date;
import java.util.logging.Logger;

public class CostCalculatorImpl implements CostCalculator
{

    static final Logger logger = Logger.getLogger(CostCalculatorImpl.class.getName());

    @Override
    public double calculateCost(ParkingTicket parkingTicket)
    {

       Date currentDate = new Date();
       
       long duration = currentDate.getTime() - parkingTicket.getEntryTime().getTime();
       
         double hours = (double) duration / (1000 * 60 * 60);
         
        double minCost = 20.0;
        double cost = 0.0;
        
        if (hours <= 3) {
            cost = minCost + (10.0 * hours);
        } else {
            cost = minCost + 50.0;
        }
        
        parkingTicket.setExitTime(currentDate);
        parkingTicket.setDuration(hours);
        parkingTicket.setAmount(cost);

        logger.info("Calculated cost for ticket ID: " + parkingTicket.getTicketId() +", cost: " + cost);

        return cost;
    }

}
