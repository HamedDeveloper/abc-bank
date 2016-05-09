package com.abc;

public class MaxiAccount extends Account{

    public MaxiAccount(){
        super();
    }

    public MaxiAccount(double openingBalance){
        super(openingBalance);
    }

    @Override
    protected double interestEarned() {
        double balance = getBalance();
        if (balance <= 1000)
            return balance * 0.02;
        if (balance <= 2000)
            return 20 + (balance-1000) * 0.05;
        return 70 + (balance-2000) * 0.1;
    }

    @Override
    protected String getStatementHeader() {
        return "Maxi Savings Account";
    }
}
