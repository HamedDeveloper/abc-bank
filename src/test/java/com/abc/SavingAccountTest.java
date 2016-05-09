package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingAccountTest {
    @Test
    public void interestOverThousand(){
        Account account = new SavingAccount(1500);
        assertEquals(2, account.interestEarned(), AccountTest.DOUBLE_DELTA);
    }

    @Test
    public void interestLessThanThousand(){
        Account account = new SavingAccount(500);
        assertEquals(0.5, account.interestEarned(), AccountTest.DOUBLE_DELTA);
    }
}
