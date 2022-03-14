package com.tw.wallet;

public enum Currency {
    Rupee(1),
    USDollar(76),
    Euro(1 / 0.012);

    private final double baseFactor;

    Currency(double baseFactor) {
        this.baseFactor = baseFactor;
    }

    public double convertToBaseFactor(double value) {
        return value * baseFactor;
    }

    public double convertToCurrency(double value, Currency requiredCurrency) {
        return convertToBaseFactor(value) / requiredCurrency.baseFactor;
    }
};
