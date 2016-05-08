package com.abc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void deposit() {
        Account checkingAccount = new Account(Account.CHECKING, 500);
        assertEquals(500, checkingAccount.getBalance(), DOUBLE_DELTA);
        checkingAccount.deposit(300);
        assertEquals(800, checkingAccount.getBalance(), DOUBLE_DELTA);
    }

    @Test
    public void withdraw() {
        Account checkingAccount = new Account(Account.CHECKING, 500);
        checkingAccount.withdraw(200);
        assertEquals(300, checkingAccount.getBalance(), DOUBLE_DELTA);
    }

    @Test
    public void withdrawMoreThanBalance() {
        thrown.expect(IllegalArgumentException.class);
        Account checkingAccount = new Account(Account.CHECKING, 500);
        checkingAccount.withdraw(700);
    }

}
