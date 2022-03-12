package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;

import static com.tw.wallet.Money.createRupee;

public class Wallet {
    private Money balance;

    public Wallet() throws InvalidAmountException {
        balance = createRupee(0);
    }

    public void add(Money money) throws InvalidAmountException {
        balance = balance.add(money);
    }

    public Money balance() {
        return balance;
    }
}
