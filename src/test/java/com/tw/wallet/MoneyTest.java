package com.tw.wallet;

import com.tw.exceptions.BalanceNotAvailableException;
import com.tw.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static com.tw.wallet.Money.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void shouldBeAbleToCreateMoney() throws InvalidAmountException {
        Money hundredRupee = createRupee(100);

        assertThat(createRupee(100), is(equalTo(hundredRupee)));
    }

    @Test
    void shouldNotBeAbleToCreateMoneyWhenValueIsNegative() {
        assertThrows(InvalidAmountException.class, () -> createRupee(-10));
    }

    @Test
    void shouldBeAbleToAddTwoMoney() throws InvalidAmountException {
        Money tenRupee = createRupee(10);
        Money fiveRupee = createRupee(5);

        Money fifteenRupee = tenRupee.add(fiveRupee);

        assertThat(createRupee(15), is(equalTo(fifteenRupee)));
    }

    @Test
    void shouldAssertNotSameWhenTwoMoneyAreCompared() throws InvalidAmountException {
        Money tenRupee = createRupee(10);
        Money anotherTenRupee = createRupee(10);

        assertNotSame(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssertEqualsWhenValueOfTwoMoneyAreSame() throws InvalidAmountException {
        Money tenRupee = createRupee(10);
        Money anotherTenRupee = createRupee(10);

        assertEquals(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssertFalseWhenACurrencyIsComparedToNull() throws InvalidAmountException {
        Money tenRupee = createRupee(10);

        assertNotEquals(tenRupee, null);
    }

    @Test
    void shouldAssertFalseWhenACurrencyIsComparedToAnotherCurrency() throws InvalidAmountException {
        Money tenRupee = createRupee(10);
        Money tenUSDollar = createUSDollar(10);

        assertNotEquals(tenRupee, tenUSDollar);
    }

    @Test
    void shouldAssertTrueWhenOneUSDollarIsEqualToSeventySixRupee() throws InvalidAmountException {
        Money seventySixRupee = createRupee(76);
        Money oneUSDollar = createUSDollar(1);

        assertEquals(seventySixRupee, oneUSDollar);
    }

    @Test
    void shouldAssertTrueWhenOneRupeeIsZeroPointZeroOneTwoEuro() throws InvalidAmountException {
        Money oneRupee = createRupee(1);
        Money zeroPointZeroOneTwoEuro = createEuro(0.012);

        assertEquals(oneRupee, zeroPointZeroOneTwoEuro);
    }

    @Test
    void shouldBeAbleToSubtractTwoMoney() throws InvalidAmountException, BalanceNotAvailableException {
        Money thirtyRupee = createRupee(30);
        Money twentyRupee = createRupee(20);

        Money tenRupee = thirtyRupee.subtract(twentyRupee);

        assertThat(createRupee(10), is(equalTo(tenRupee)));
    }
}