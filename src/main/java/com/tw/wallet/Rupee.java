package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;

public class Rupee {
    private final int value;

    public Rupee(int value) throws InvalidAmountException {
        if (value <= 0)
            throw new InvalidAmountException("Enter a value above Zero");
        this.value = value;
    }

    public int value() {
        return value;
    }
}
