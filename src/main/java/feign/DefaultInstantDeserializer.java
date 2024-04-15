package feign;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultInstantDeserializer extends JsonDeserializer<LocalDateTime> {


    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        return LocalDateTime.parse(p.getText().substring(0, p.getText().length() - 1));
    }
}
