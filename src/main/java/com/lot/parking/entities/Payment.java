package com.lot.parking.entities;

public class Payment
{
    private String paymentMode;
    private double amount;
    private int transactionId;
    
    public String getPaymentMode()
    {
        return paymentMode;
    }
    public void setPaymentMode(String paymentMode)
    {
        this.paymentMode = paymentMode;
    }
    public double getAmount()
    {
        return amount;
    }
    public void setAmount(double amount)
    {
        this.amount = amount;
    }
    public int getTransactionId()
    {
        return transactionId;
    }
    public void setTransactionId(int transactionId)
    {
        this.transactionId = transactionId;
    }
    @Override
    public String toString()
    {
        return "Payment [paymentMode=" + paymentMode + ", amount=" + amount + ", transactionId=" + transactionId + "]";
    }
    public Payment(String paymentMode, double amount, int transactionId)
    {
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.transactionId = transactionId;
    }
}
