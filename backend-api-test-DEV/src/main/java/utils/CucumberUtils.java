package utils;

import com.epam.reportportal.service.ReportPortal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.cucumber.messages.internal.com.google.gson.GsonBuilder;
import utils.service.JsonToString;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Map;

public class CucumberUtils {

    public static String dataTableToJson(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        GsonBuilder gsonMapBuilder = new GsonBuilder();
        Gson gsonObject = gsonMapBuilder.create();
        return rows.size() > 1 ? gsonObject.toJson(rows) : gsonObject.toJson(rows.get(0));
    }

    public static <T> T getObjectBodyFromJson(String json, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        T mappedBody = null;
        try {
            mappedBody = mapper.readValue(json, clazz);
            return mappedBody;
        } catch (IOException e) {
            mappedBody = mapper.readValue(dataTableToJson(json), clazz);
            return mappedBody;
        }
    }

    public static String dataTableToJson(Object table) {
        return JsonToString.objectToJsonString.apply(table);
    }

    public static <T> T getObjectBody(DataTable table, Class<T> clazz) throws JsonProcessingException {
        ReportPortal.emitLog(table.toString(), "INFO", Date.from(Instant.now()));
        ObjectMapper mapper = new ObjectMapper();
        T mappedBody = null;
        try {
            mappedBody = mapper.readValue(dataTableToJson(table), clazz);
            return mappedBody;
        } catch (IOException e) {
            mappedBody = mapper.readValue("[" + dataTableToJson(table) + "]", clazz);
            return mappedBody;
        }
    }


}
