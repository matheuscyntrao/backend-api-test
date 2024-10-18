package utils.service;

import org.apache.commons.lang.text.StrSubstitutor;

import java.util.Map;
import java.util.function.BiFunction;

public interface ServiceBase {
    BiFunction<String, Map<String, String>, String> pathBuilder = (url, path) -> {
        return new StrSubstitutor(path).replace(url.replace("${", "{").replace("{", "${"));
    };
}
