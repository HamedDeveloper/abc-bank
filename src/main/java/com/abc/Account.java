package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    private List<Transaction> transactions;
    private double balance;

    public Account(int accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public Account(int accountType, double openingBalance) {
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit amount must be greater than zero");
        } else {
            this.balance += amount;
            this.transactions.add(new Transaction(amount));
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("withdraw amount must be greater than zero");
        } else if (amount > this.balance) {
            throw new IllegalArgumentException("withdraw amount cannot be greater than balance");
        } else {
            this.balance -= amount;
            this.transactions.add(new Transaction(-amount));
        }
    }

    public double interestEarned() {
        double amount = sumTransactions();
        switch(accountType){
            case SAVINGS:
                return getSavingInterest(amount);
            case MAXI_SAVINGS:
                return getMaxInterest(amount);
            default:
                return getCheckingInterest(amount);
        }
    }

    private double getCheckingInterest(double amount) {
        return amount * 0.001;
    }

    private double getMaxInterest(double amount) {
        if (amount <= 1000)
            return amount * 0.02;
        if (amount <= 2000)
            return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
    }

    private double getSavingInterest(double amount) {
        if (amount <= 1000)
            return amount * 0.001;
        else
            return 1 + (amount-1000) * 0.002;
    }


    public double sumTransactions() {
        double amount = 0.0;
        for (Transaction t: this.transactions)
            amount += t.amount;
        return amount;
    }

    public int getAccountType() {
        return this.accountType;
    }

    public double getBalance(){
        return this.balance;
    }

    public List<Transaction> getTransactions(){
        return this.transactions;
    }

    public void transfer(Account other, double amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("transfer amount must be greater than zero");
        } else if (this.balance < amount) {
            throw new IllegalArgumentException("transfer amount must be less than balance");
        } else {
            this.balance -= amount;
            other.balance += amount;
            this.transactions.add(new Transaction(amount));
            other.transactions.add(new Transaction(-amount));
        }

    }

}
