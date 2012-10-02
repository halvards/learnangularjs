package com.thoughtworks.learnangularjs.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.thoughtworks.learnangularjs.serialization.AmountDeserializer;
import com.thoughtworks.learnangularjs.serialization.AmountSerializer;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonSerialize(using = AmountSerializer.class)
@JsonDeserialize(using = AmountDeserializer.class)
public class Amount implements Comparable<Amount> {
    private static final int SCALE = 2;

    private final BigDecimal amount;

    public Amount(String amount) {
        this(new BigDecimal(Preconditions.checkNotNull(amount)));
    }

    public Amount(BigDecimal amount) {
        this.amount = amount.setScale(SCALE, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Amount that = (Amount) other;
        if (!this.amount.equals(that.amount)) {
            return false;
        }
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
