package com.tw.wallet;

import com.tw.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

class RupeeTest {
    @Test
    void shouldReturnValueAsHundredWhenInputIsHundred() throws InvalidAmountException {
        Rupee rupee = new Rupee(100);

        assertThat(new Rupee(100), is(equalTo(rupee)));
    }

    @Test
    void shouldNotCreateARupeeWhenInputIsNegative() {
        assertThrows(InvalidAmountException.class, () -> new Rupee(-10));
    }

    @Test
    void shouldReturnFifteenRupeeWhenTenRupeeAndFiveRupeeIsAdded() throws InvalidAmountException {
        Rupee tenRupee = new Rupee(10);
        Rupee fiveRupee = new Rupee(5);

        Rupee fifteenRupee = tenRupee.add(fiveRupee);

        assertThat(new Rupee(15), is(equalTo(fifteenRupee)));
    }

    @Test
    void shouldAssertNotSameWhenTwoTenRupeesAreCompared() throws InvalidAmountException {
        Rupee tenRupee = new Rupee(10);
        Rupee anotherTenRupee = new Rupee(10);

        assertNotSame(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssertTrueWhenTheValueOfTwoTenRupeesAreEqual() throws InvalidAmountException {
        Rupee tenRupee = new Rupee(10);
        Rupee anotherTenRupee = new Rupee(10);

        assertEquals(tenRupee, anotherTenRupee);
    }

    @Test
    void shouldAssertFalseWhenATenRupeeIsComparedToNull() throws InvalidAmountException {
        Rupee tenRupee = new Rupee(10);

        assertNotEquals(tenRupee, null);
    }

    @Test
    void shouldAssertFalseWhenATenRupeeIsComparedToAnotherType() throws InvalidAmountException {
        Rupee tenRupee = new Rupee(10);
        USDollar tenUSDollar = new USDollar(10);

        assertNotEquals(tenRupee, tenUSDollar);
    }

    @Test
    void shouldReturnTenRupeeWhenThreeRupeeAndSevenRupeeIsAdded() throws InvalidAmountException {
        Rupee threeRupee = new Rupee(3);
        Rupee sevenRupee = new Rupee(7);

        Rupee tenRupee = threeRupee.add(sevenRupee);

        assertThat(new Rupee(10), is(equalTo(tenRupee)));
    }

    @Test
    void shouldAssertTrueWhenOneUSDollarIsEqualToSeventySixRupee() throws InvalidAmountException {
        Rupee seventySixRupee = new Rupee(76);
        USDollar oneUSDollar = new USDollar(1);

        assertEquals(seventySixRupee, oneUSDollar);
    }
}