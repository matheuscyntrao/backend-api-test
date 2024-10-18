package utils.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface JsonToString {

    Function<String, String> jsonStringFormatter = (json) -> {
        String resultado;
        ObjectMapper mapper = new ObjectMapper();
        try {
            resultado = (mapper.writerWithDefaultPrettyPrinter().writeValueAsString(
                    mapper.readValue(json, Object.class)
            ));
        } catch (IOException e) {
            //Tenta parsear para JSON, caso contrario retorna a string, caso de base64 ou afins
            resultado = json;
        }
        return resultado;
    };

    Function<Object, String> objectToJsonString = (objeto) -> {
        ObjectMapper mapper = new ObjectMapper();
        String retorno = "";
        try {
            retorno = mapper.writeValueAsString(objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    };

    BiFunction<Object, String, String> removeArguments = (object, argument) -> {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = (ObjectNode) mapper.valueToTree(object);
        node.remove(argument);
        return node.toString();
    };

    BiFunction<String, String, String> removeStringArguments = (object, argument) -> {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = null;
        try {
            node = (ObjectNode) new ObjectMapper().readTree(object);
            node.remove(argument);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node.toString();
    };

    BiFunction<Object, String, String> setInvalidArguments = (object, argument) -> {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = (ObjectNode) mapper.valueToTree(object);
        String jsonString = "{\"" + argument + "\":\"invalidValue\"";
        JsonNode actualObj = null;
        try {
            actualObj = mapper.readTree(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode1 = actualObj.get(argument);
        node.replace(argument, jsonNode1);
        return node.toString();
    };

    BiFunction<String, String, String> setStringInvalidArguments = (object, argument) -> {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = null;
        String jsonString = "{\"" + argument + "\":\"invalidValue\"";
        JsonNode actualObj = null;
        try {
            actualObj = (ObjectNode) new ObjectMapper().readTree(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonNode jsonNode1 = actualObj.get(argument);
        node.replace(argument, jsonNode1);
        return node.toString();
    };
}

