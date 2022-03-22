package com.tw.wallet;

import com.tw.exceptions.BalanceNotAvailableException;
import com.tw.exceptions.InvalidAmountException;

import static com.tw.wallet.Money.createRupee;

public class Wallet {
    private Money balance;

    public Wallet() throws InvalidAmountException {
        balance = createRupee(0);
    }

    public void deposit(Money money) throws InvalidAmountException {
        balance = balance.add(money);
    }

    public void withdraw(Money money) throws InvalidAmountException, BalanceNotAvailableException {
        if (money.value(Currency.Rupee) > balance.value(Currency.Rupee))
            throw new BalanceNotAvailableException();
        balance = balance.subtract(money);
    }

    public Money balance() {
        return balance;
    }

    public double valueOfBalance(Currency currency) {
        return balance.value(currency);
    }
}
