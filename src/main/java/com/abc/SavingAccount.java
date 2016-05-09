package com.abc;

public class SavingAccount extends Account{

    public SavingAccount(){
        super();
    }

    public SavingAccount(double openingBalance){
        super(openingBalance);
    }

    @Override
    protected double interestEarned() {
        double balance = getBalance();
        if (balance <= 1000)
            return balance * 0.001;
        else
            return 1 + (balance-1000) * 0.002;
    }

    @Override
    protected String getStatementHeader() {
        return "Savings Account";
    }
}
