package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;

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

        if (obj.getClass() != Rupee.class) return false;

        Rupee anotherRupee = (Rupee) obj;
        return anotherRupee.value == this.value;
    }
}
