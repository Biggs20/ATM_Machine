package com.company;

import java.math.BigDecimal;

public class Withdrawal
{
    private int withdrawal = 198;

    private int oneDollarBills;
    private int fiveDollarBills;
    private int tenDollarBills;
    private int twentyDollarBills;

    public void amountOfBills()
    {
        twentyDollarBills = withdrawal / 20;
        tenDollarBills = (withdrawal % 20) / 10;
        fiveDollarBills = ((withdrawal % 20) % 10) / 5;
        oneDollarBills = (((withdrawal % 20) % 10) % 5);

        System.out.println("20 Dollar Bills: " + twentyDollarBills);
        System.out.println("10 Dollar Bills: " + tenDollarBills);
        System.out.println("5 Dollar Bills: " + fiveDollarBills);
        System.out.println("1 Dollar Bills: " + oneDollarBills);
        System.out.println("--------------------------------------");
        System.out.println("Convenience Fee: " + addConvenienceFee());
    }

    public BigDecimal addConvenienceFee()
    {
        BigDecimal convenienceFee = new BigDecimal("1.00");
        double transactionFee = (twentyDollarBills + tenDollarBills + fiveDollarBills + oneDollarBills) * .1;
        BigDecimal transactionFeeBD = new BigDecimal(transactionFee);
        BigDecimal totalFee = new BigDecimal("0.00");

        totalFee = convenienceFee.add(transactionFeeBD);
        totalFee = totalFee.setScale(2, BigDecimal.ROUND_HALF_UP);

        return totalFee;
    }
}
