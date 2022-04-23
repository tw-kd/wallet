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
    void shouldBeAbleToDepositMoneyToWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money hundredRupee = createRupee(100);

        wallet.deposit(hundredRupee);
        Money balance = wallet.balance();

        assertThat(balance, is(equalTo(createRupee(100.0))));
    }

    @Test
    void shouldNotBeAbleToDepositMoneyToWalletWhenMoneyIsNegativeOrZero() throws InvalidAmountException {
        Wallet wallet = new Wallet();

        assertThrows(InvalidAmountException.class, () -> wallet.deposit(createRupee(-100)));
    }

    @Test
    void shouldBeAbleToWithdrawnMoneyFromWallet() throws InvalidAmountException, BalanceNotAvailableException {
        Wallet wallet = new Wallet();
        Money fiftyRupee = createRupee(50);
        Money thirtyRupee = createRupee(30);
        wallet.deposit(fiftyRupee);

        wallet.withdraw(thirtyRupee);
        Money balance = wallet.balance();

        assertThat(balance, is(equalTo(createRupee(20))));
    }

    @Test
    void shouldNotBeAbleToWithdrawMoreThanBalanceFromWallet() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money tenRupee = createRupee(10);
        Money twoHundredRupee = createRupee(200);

        wallet.deposit(tenRupee);

        assertThrows(BalanceNotAvailableException.class, () -> wallet.withdraw(twoHundredRupee));
    }

    @Test
    void shouldReturnBalanceWhenMoneyIsWithdrawnFromWalletWithMultipleTypesOfCurrencies() throws InvalidAmountException, BalanceNotAvailableException {
        Wallet wallet = new Wallet();
        Money oneRupee = createRupee(1);
        Money oneUSDollar = createUSDollar(1);
        Money tenRupee = createRupee(10);
        wallet.deposit(oneRupee);
        wallet.deposit(oneUSDollar);

        wallet.withdraw(tenRupee);
        Money balance = wallet.balance();

        assertThat(balance, is(equalTo(createRupee(67))));
    }

    @Test
    void shouldBeAbleToReturnUSDollarValueFromWalletWithMultipleTypesOfCurrencies() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money seventySixRupee = createRupee(76);
        Money oneUSDollar = createUSDollar(1);
        Money oneHundredFiftyTwoRupee = createRupee(152);
        wallet.deposit(seventySixRupee);
        wallet.deposit(oneUSDollar);
        wallet.deposit(oneHundredFiftyTwoRupee);

        double balanceValueInUSDollars = wallet.valueOfBalance(Currency.USDollar);

        assertThat(balanceValueInUSDollars, is(equalTo(4.0)));
    }

    @Test
    void shouldBeAbleToReturnRupeeValueFromWalletWithMultipleTypesOfCurrencies() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money fiftyRupee = createRupee(50);
        Money oneUSDollar = createUSDollar(1);
        wallet.deposit(fiftyRupee);
        wallet.deposit(oneUSDollar);

        double balanceValueInRupee = wallet.valueOfBalance(Currency.Rupee);

        assertThat(balanceValueInRupee, is(equalTo(126.0)));
    }

    @Test
    void shouldBeAbleToReturnEuroValueFromWalletWithMultipleTypesOfCurrencies() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        Money oneUSDollar = createUSDollar(1);

        wallet.deposit(oneUSDollar);
        double balanceValueInEuro = wallet.valueOfBalance(Currency.Euro);

        assertThat(balanceValueInEuro, is(equalTo(0.912)));
    }
}
