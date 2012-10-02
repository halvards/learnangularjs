package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnangularjs.domain.Amount;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AmountDeserializerTest {
    @Test
    public void testDeserializeAmount() throws Exception {
        Amount deserialisedAmount = new ObjectMapper().readValue("\"0.40\"", Amount.class);
        assertThat(deserialisedAmount, equalTo(new Amount("0.4")));
    }
}
