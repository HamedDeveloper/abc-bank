package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxiAccountTest {
    @Test
    public void interestOverTwoThousand(){
        Account account = new MaxiAccount(3500);
        assertEquals(220, account.interestEarned(), AccountTest.DOUBLE_DELTA);
    }

    @Test
    public void interestOverThousandLessThanTwoThousand(){
        Account account = new MaxiAccount(1500);
        assertEquals(45, account.interestEarned(), AccountTest.DOUBLE_DELTA);
    }

    @Test
    public void interestLessThanThousand(){
        Account account = new MaxiAccount(500);
        assertEquals(10, account.interestEarned(), AccountTest.DOUBLE_DELTA);
    }

}
