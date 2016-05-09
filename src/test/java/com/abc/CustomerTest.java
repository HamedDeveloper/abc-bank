package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void customerStatementGeneration(){

        Account checkingAccount = new CheckingAccount();
        Account savingsAccount = new SavingAccount();

        Customer henry = new Customer("Henry");
        henry.openAccount(checkingAccount);
        henry.openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void oneAccount(){
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(new SavingAccount());
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void twoAccount(){
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(new SavingAccount());
        oscar.openAccount(new CheckingAccount());
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test
    public void threeAcounts() {
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(new SavingAccount());
        oscar.openAccount(new CheckingAccount());
        oscar.openAccount(new MaxiAccount());
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
