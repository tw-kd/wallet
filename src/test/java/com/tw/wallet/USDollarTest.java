package com.tw.wallet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class USDollarTest {
    @Test
    void shouldReturnValueAsOneUSDollarWhenOneUSDollarIsCreated() {
        USDollar oneUSDollar = new USDollar(1);
        System.out.println(oneUSDollar.hashCode());
        assertEquals(new USDollar(1), oneUSDollar);
    }
}