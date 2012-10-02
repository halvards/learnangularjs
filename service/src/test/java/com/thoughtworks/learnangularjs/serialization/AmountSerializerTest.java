package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.learnangularjs.domain.Amount;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


public class AmountSerializerTest {
    @Test
    public void testShouldSerializeAmountAsStringWithTwoDecimals() throws Exception {
        Amount amount = new Amount("0.4");
        String jsonValue = new ObjectMapper().writeValueAsString(amount);
        assertThat(jsonValue, equalTo("\"0.40\""));
    }
}
