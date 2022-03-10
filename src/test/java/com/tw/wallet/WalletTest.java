package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldReturnBalanceAsHundredWhenHundredIsAddedToWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();

        wallet.add(new Rupee(100));
        int balance = wallet.balance();

        assertThat(balance, is(equalTo(100)));
    }

    @Test
    void shouldNotAddBalanceWhenNegativeOrZeroIsAddedToWallet() {
        Wallet wallet = new Wallet();
        assertThrows(InvalidAmountException.class, () -> wallet.add(new Rupee(-100)));
    }
}
