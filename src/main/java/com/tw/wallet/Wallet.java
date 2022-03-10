package com.tw.wallet;

public class Wallet {
    private int balance;

    public Wallet() {
        this.balance = 0;
    }

    public void add(Rupee rupee) {
        balance += rupee.value();
    }

    public int balance() {
        return balance;
    }
}
