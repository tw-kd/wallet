package com.tw.wallet;

public class Wallet {
    private int amount;

    public Wallet() {
        this.amount = 0;
    }

    public void add(int amount) {
        this.amount += amount;
    }

    public int balance() {
        return amount;
    }
}
