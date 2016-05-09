package com.abc;

public class SavingAccount extends Account{

    public SavingAccount(){
        super();
    }

    public SavingAccount(double openingBalance){
        super(openingBalance);
    }

    @Override
    protected double getInterest(double amount) {
        if (amount <= 1000)
            return amount * 0.001;
        else
            return 1 + (amount-1000) * 0.002;
    }

    @Override
    protected String getStatementHeader() {
        return "Savings Account";
    }
}
