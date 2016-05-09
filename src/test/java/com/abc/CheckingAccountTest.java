package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckingAccountTest {
    @Test
    public void interest(){
        Account account = new CheckingAccount(500);
        assertEquals(0.5, account.interestEarned(), AccountTest.DOUBLE_DELTA);
    }
}
