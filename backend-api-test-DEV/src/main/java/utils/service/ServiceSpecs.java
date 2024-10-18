package utils.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ServiceSpecs {
    private String url;
    public HashMap<String, String> header = new HashMap<>() {{
        put("Content-Type", "application/json");
    }};
    public HashMap<String, String> param = new HashMap<>();
    private String body = "{}";
    public HashMap<String, String> path = new HashMap<>();

    @Getter
    @Setter
    public Map<Object, Object> formData = new HashMap<>();

    @Override
    public String toString() {
        return "\nurl: \n" + url +
                "\nheader: \n" + header +
                "\nparam: \n" + param +
                "\nbody: \n" + getBody() +
                "\n" +
                "";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, String> getHeader() {
        return header;
    }

    public String[] getHeaderList() {
        String[] lista = new String[header.size() * 2];
        Integer posicao = -1;

        for (Map.Entry<String, String> entry : header.entrySet()) {
            posicao++;
            lista[posicao] = entry.getKey();
            posicao++;
            lista[posicao] = entry.getValue();
        }
        return lista;
    }

    public void setHeader(HashMap<String, String> header) {
        this.header = header;
    }

    public HashMap<String, String> getParam() {
        return param;
    }

    public String getStringParam() {
        return BaseRequest.paramBuilder.apply(this.param);
    }

    public void setParam(HashMap<String, String> param) {
        this.param = param;
    }

    public String getBody() {
        return JsonToString.jsonStringFormatter.apply(body);
    }

    public <T> T getObjectBody(Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap bean;
        T mappedBody = null;
        try {
            mappedBody = mapper.readValue(getBody(), clazz);
            BeanValidator.validator.accept(mappedBody);
            return mappedBody;
        } catch (IOException e) {
            System.out.println("erro ao efetuar o parse " + e.getMessage());
        }
        return mappedBody;
    }

    public void setBody(Object object) {
        this.body = JsonToString.objectToJsonString.apply(object).replace("\"null\"", "null");
    }

    public void setBody(String body) {
        this.body = body.replace("\"null\"", "null");
    }

    public HashMap<String, String> getPath() {
        return path;
    }

    public void setPath(HashMap<String, String> path) {
        this.path = path;
    }
}
