package utils.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ObjectMapperUtils {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    public static ObjectMapper getInstance() {
        return objectMapper.copy();
    }

    @SneakyThrows
    public static Map<Object, Object> transformObjectToMap(Object objectToMap) {
        var jsonRepresentation = objectMapper.writeValueAsString(objectToMap);
        return objectMapper.readValue(jsonRepresentation, new TypeReference<>() {});
    }
}
