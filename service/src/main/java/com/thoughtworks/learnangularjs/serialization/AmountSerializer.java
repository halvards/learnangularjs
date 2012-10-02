package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.thoughtworks.learnangularjs.domain.Amount;

import java.io.IOException;
import java.math.BigDecimal;

public class AmountSerializer extends JsonSerializer<Amount> {
    @Override
    public void serialize(Amount value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        jsonGenerator.writeString(value.toString());
    }
}
