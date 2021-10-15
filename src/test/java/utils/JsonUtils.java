package utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@UtilityClass
public class JsonUtils {
    private static final Logger logger = LogManager.getLogger(JsonUtils.class);
    private static final ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        MAPPER.registerModule(new JavaTimeModule());
    }

    @SneakyThrows
    public static <T> T decode(String json, Class<T> clazz) {
        return MAPPER.readValue(json, clazz);
    }
}
