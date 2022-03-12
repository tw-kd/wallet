package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;

import java.util.HashMap;
import java.util.Objects;


public class Money {
    private final double value;
    private final Currency currency;

    private Money(double value, Currency currency) throws InvalidAmountException {
        if (value < 0)
            throw new InvalidAmountException("Enter a value above Zero");
        this.value = value;
        this.currency = currency;
    }

    public static Money createRupee(double value) throws InvalidAmountException {
        return new Money(value, Currency.Rupee);
    }

    public static Money createUSDollar(double value) throws InvalidAmountException {
        return new Money(value, Currency.USDollar);
    }

    public static Money createEuro(double value) throws InvalidAmountException {
        return new Money(value, Currency.Euro);
    }

    public Money add(Money anotherMoney) throws InvalidAmountException {
        return new Money(currency.convertToBaseFactor(value) + anotherMoney.currency.convertToBaseFactor(anotherMoney.value), Currency.Rupee);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj.getClass() != Money.class) return false;

        Money anotherMoney = (Money) obj;
        return currency.convertToBaseFactor(value) == anotherMoney.currency.convertToBaseFactor(anotherMoney.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency.convertToBaseFactor(value));
    }
}
