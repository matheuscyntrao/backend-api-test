package utils;


import com.epam.reportportal.service.ReportPortal;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.cucumber.messages.internal.com.google.gson.JsonParser;

import java.sql.Date;
import java.time.Instant;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

import static java.lang.Thread.currentThread;

public interface Util {

    Random RANDOM = new Random();

    BiFunction<String, String, Map> removerCampo = (body, campo) -> {
        Gson gson = new Gson();
        Map jsonNodes = gson.fromJson(body, Map.class);
        jsonNodes.remove(campo);
        return jsonNodes;
    };

    BiFunction<String, String, Map> alterarCampoInvalido = (body, campo) -> {
        Gson gson = new Gson();
        Map jsonNodes = gson.fromJson(body, Map.class);
        jsonNodes.replace(campo, "invalido");
        return jsonNodes;
    };

    Function<String, String> rota = (rota) -> {
        ReportPortal.emitLog("Thread " + currentThread().getId() + currentThread().getName(), "DEBUG", Date.from(Instant.now()));
        return currentThread().getId() + rota;
    };

    Function<String, String> uri = (serviceName) -> {
//        return "http://localhost:9001";
        return UriProperties.local && UriProperties.serviceName.equals(serviceName) ? "http://localhost:9001" : UriProperties.url;
    };

    public static String removeCampoJson(String json, String campo) {
        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
        String[] campos = campo.split("\\.");
        JsonObject key = new JsonObject();
        JsonObject obj = (JsonObject) parser.parse(json);
        if (campos.length >= 1) {
            for (Object c : campos) {
                if (c.toString() != campos[campos.length - 1]) {
                    key = obj.getAsJsonObject(c.toString());
                }
            }
            key.remove(campos[campos.length - 1]);
        } else {
            obj.remove(campo);
        }
        return gson.toJson(obj);
    }

    public static String alteraCampoJson(String json, String campo, String valor) {
        JsonParser parser = new JsonParser();
        Gson gson = new Gson();
        String[] campos = campo.split("\\.");
        JsonObject obj = (JsonObject) parser.parse(json);

        if(campos.length==1){
            obj.remove(campo);
            obj.addProperty(campo, valor);
        }
        if(campos.length==2){
            obj.getAsJsonObject(campos[0]).remove(campos[1]);
            obj.getAsJsonObject(campos[0]).addProperty(campos[1], valor);
        }
        if(campos.length==3){
            obj.getAsJsonObject(campos[0]).getAsJsonObject(campos[1]).remove(campos[2]);
            obj.getAsJsonObject(campos[0]).getAsJsonObject(campos[1]).addProperty(campos[2], valor);
        }
        if(campos.length==4){
            obj.getAsJsonObject(campos[0]).getAsJsonObject(campos[1]).getAsJsonObject(campos[2]).remove(campos[3]);
            obj.getAsJsonObject(campos[0]).getAsJsonObject(campos[1]).getAsJsonObject(campos[2]).addProperty(campos[3], valor);
        }
        return gson.toJson(obj);
    }

    IntBinaryOperator getRandomPointer = (high, low) -> RANDOM.nextInt(high - low) + low;
}
