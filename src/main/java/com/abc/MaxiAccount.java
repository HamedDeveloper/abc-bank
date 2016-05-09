package com.abc;

public class MaxiAccount extends Account{

    public MaxiAccount(){
        super();
    }

    public MaxiAccount(double openingBalance){
        super(openingBalance);
    }

    @Override
    protected double getInterest(double amount) {
        if (amount <= 1000)
            return amount * 0.02;
        if (amount <= 2000)
            return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
    }

    @Override
    protected String getStatementHeader() {
        return "Maxi Savings Account";
    }
}
