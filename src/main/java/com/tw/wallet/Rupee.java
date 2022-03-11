package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;

import java.util.HashMap;


public class Rupee {
    private final double value;

    public Rupee(double value) throws InvalidAmountException {
        if (value < 0)
            throw new InvalidAmountException("Enter a value above Zero");
        this.value = value;
    }

    public Rupee add(Rupee anotherRupee) throws InvalidAmountException {
        return new Rupee(this.value + anotherRupee.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj.getClass() != Rupee.class) {
            if (obj.getClass() == USDollar.class) {
                USDollar usDollar = (USDollar) obj;
                return this.value / usDollar.value() == 76.0;
            }
            return false;
        }

        Rupee anotherRupee = (Rupee) obj;
        return anotherRupee.value == this.value;
    }
}
