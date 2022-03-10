package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;

public class Wallet {
    private Rupee balance;

    public Wallet() throws InvalidAmountException {
        balance = new Rupee(0);
    }

    public void add(Rupee rupee) throws InvalidAmountException {
        balance = balance.add(rupee);
    }

    public Rupee balance() {
        return balance;
    }
}
