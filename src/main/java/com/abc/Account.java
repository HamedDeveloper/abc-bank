package com.abc;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private List<Transaction> transactions;
    private double balance;

    public Account() {
        this.transactions = new ArrayList<>();
        this.balance = 0;
    }

    public Account(double openingBalance) {
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

    protected abstract String getStatementHeader();

    protected abstract double interestEarned();
}
