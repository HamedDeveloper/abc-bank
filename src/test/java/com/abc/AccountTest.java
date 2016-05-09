package com.abc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    static final double DOUBLE_DELTA = 1e-15;
    private Account checkingAccount;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        checkingAccount = new CheckingAccount(500);
    }

    @Test
    public void deposit() {
        assertEquals(500, checkingAccount.getBalance(), DOUBLE_DELTA);
        checkingAccount.deposit(300);
        assertEquals(800, checkingAccount.getBalance(), DOUBLE_DELTA);
    }

    @Test
    public void withdraw() {
        checkingAccount.withdraw(200);
        assertEquals(300, checkingAccount.getBalance(), DOUBLE_DELTA);
        assertEquals(300, checkingAccount.getBalance(), DOUBLE_DELTA);
    }

    @Test
    public void withdrawMoreThanBalance() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expect(IllegalArgumentException.class);
        checkingAccount.withdraw(700);
    }

    @Test
    public void transfer() {
        Account firstAccount = new SavingAccount(600);
        Account secondAccount = new CheckingAccount(300);
        firstAccount.transfer(secondAccount, 100);
        assertEquals(500, firstAccount.getBalance(), DOUBLE_DELTA);
        assertEquals(400, secondAccount.getBalance(), DOUBLE_DELTA);
    }

    @Test
    public void transferMoreThanBalance() {
        thrown.expect(IllegalArgumentException.class);
        Account firstAccount = new CheckingAccount(600);
        Account secondAccount = new SavingAccount(300);
        firstAccount.transfer(secondAccount, 700);
    }
}
