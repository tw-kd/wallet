package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static com.tw.wallet.Money.createRupee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldReturnBalanceAsHundredWhenHundredIsAddedToWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();

        wallet.add(createRupee(100));
        Money balance = wallet.balance();

        assertThat(balance, is(equalTo(createRupee(100.0))));
    }

    @Test
    void shouldNotAddBalanceWhenNegativeOrZeroIsAddedToWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        assertThrows(InvalidAmountException.class, () -> wallet.add(createRupee(-100)));
    }
}
