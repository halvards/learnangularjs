package com.thoughtworks.learnangularjs.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.thoughtworks.learnangularjs.domain.Amount;

import java.io.IOException;

public class AmountDeserializer extends JsonDeserializer<Amount> {
    @Override
    public Amount deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        return new Amount(parser.getText());
    }
}
