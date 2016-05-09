package com.abc;

public class CheckingAccount extends Account {

    public CheckingAccount(){
        super();
    }

    public CheckingAccount(double openingBalance){
        super(openingBalance);
    }

    @Override
    protected double interestEarned(double amount) {
        return amount * 0.001;
    }

    @Override
    protected String getStatementHeader() {
        return "Checking Account";
    }
}
