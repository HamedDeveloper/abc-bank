package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void deposit(){
        Account checkingAccount = new Account(Account.CHECKING, 500);
        assertEquals(500, checkingAccount.getBalance(), DOUBLE_DELTA);
    }
}
