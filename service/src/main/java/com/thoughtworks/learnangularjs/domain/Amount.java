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
public class Amount extends TinyType<BigDecimal> {
    private static final int SCALE = 2;

    public Amount(String amount) {
        this(new BigDecimal(Preconditions.checkNotNull(amount)));
    }

    public Amount(BigDecimal amount) {
        super(amount.setScale(SCALE, RoundingMode.HALF_UP));
    }
}
