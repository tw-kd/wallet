package com.tw.wallet;

import com.tw.exceptions.BalanceNotAvailableException;
import com.tw.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static com.tw.wallet.Money.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldReturnBalanceAsHundredWhenHundredIsDepositedToWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money hundredRupee = createRupee(100);

        wallet.deposit(hundredRupee);
        Money balance = wallet.balance();

        assertThat(balance, is(equalTo(createRupee(100.0))));
    }

    @Test
    void shouldNotAddBalanceWhenNegativeOrZeroIsDepositedToWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();

        assertThrows(InvalidAmountException.class, () -> wallet.deposit(createRupee(-100)));
    }

    @Test
    void shouldReturnBalanceAsTwentyWhenThirtyIsWithdrawnFromWalletHavingBalanceFifty() throws InvalidAmountException, BalanceNotAvailableException {
        Wallet wallet = new Wallet();
        Money fiftyRupee = createRupee(50);
        Money thirtyRupee = createRupee(30);

        wallet.deposit(fiftyRupee);
        wallet.withdraw(thirtyRupee);
        Money balance = wallet.balance();

        assertThat(balance, is(equalTo(createRupee(20))));
    }

    @Test
    void shouldNotBeAbleToWithdrawMoreThanBalanceMoney() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money tenRupee = createRupee(10);
        Money twoHundredRupee = createRupee(200);

        wallet.deposit(tenRupee);

        assertThrows(BalanceNotAvailableException.class, () -> wallet.withdraw(twoHundredRupee));
    }
}
