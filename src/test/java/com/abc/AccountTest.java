package com.abc;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void deposit(){
        Account checkingAccount = new Account(Account.CHECKING, BigDecimal.valueOf(500));
        assertEquals(BigDecimal.valueOf(500), checkingAccount.getBalance());
    }
}
