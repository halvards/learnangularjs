package com.thoughtworks.learnangularjs.domain;

import com.google.common.base.Preconditions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Amount implements Comparable<Amount> {
    private static final int SCALE = 2;

    private final BigDecimal amount;

    public Amount(String amount) {
        this.amount = new BigDecimal(Preconditions.checkNotNull(amount));
        this.amount.setScale(SCALE, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount1 = (Amount) o;

        if (!amount.equals(amount1.amount)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }

    @Override
    public String toString() {
        return amount.toString();
    }

    @Override
    public int compareTo(Amount that) {
        return this.amount.compareTo(that.amount);
    }
}
