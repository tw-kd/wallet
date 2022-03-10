package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WalletTest {
    @Test
    void shouldReturnBalanceAsHundredWhenHundredIsAddedToWallet() {
        Wallet wallet = new Wallet();

        wallet.add(100);
        int balance = wallet.balance();

        assertThat(balance, is(equalTo(100)));
    }
}
