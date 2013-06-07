package com.thoughtworks.learnangularjs.config;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;

/**
 * <p>JSON message converter with support for setting a custom JSON prefix. This is to protect against JSON
 * hijacking attacks.</p>
 * <p>This class is only required until Spring MVC's MappingJackson2HttpMessageConverter implements a configurable
 * prefix for JSON serialisation.</p>
 * <p>See <a href="https://jira.springsource.org/browse/SPR-10627">https://jira.springsource.org/browse/SPR-10627</a>
 * for updates.</p>
 */
public class CustomPrefixJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    private String jsonPrefix;

    public void setJsonPrefix(String jsonPrefix) {
        this.jsonPrefix = jsonPrefix;
    }

    @Override
    protected void writeInternal(Object object, HttpOutputMessage outputMessage) throws IOException {
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        JsonGenerator jsonGenerator = getObjectMapper().getFactory().createGenerator(outputMessage.getBody(), encoding);
        if (getObjectMapper().isEnabled(SerializationFeature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }
        try {
            if (StringUtils.hasLength(jsonPrefix)) {
                jsonGenerator.writeRaw(jsonPrefix);
            }
            getObjectMapper().writeValue(jsonGenerator, object);
        } catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }
}
