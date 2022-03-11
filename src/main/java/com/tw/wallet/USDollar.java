package com.tw.wallet;

import java.util.Objects;

public class USDollar {
    private final double value;

    public USDollar(int value) {
        this.value = value;
    }

    public double value() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        USDollar anotherUSDollar = (USDollar) obj;
        return anotherUSDollar.value == this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
