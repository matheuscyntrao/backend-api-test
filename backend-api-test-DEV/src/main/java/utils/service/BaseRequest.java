package utils.service;

import com.epam.reportportal.service.ReportPortal;
import utils.PropertiesReader;
import utils.UriProperties;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public interface BaseRequest {

    Consumer<String> log = (texto) -> {
        String caminhoPrefixo = ClassLoader.getSystemResource("environment.properties").getPath();
        Boolean debug = Boolean.parseBoolean(new PropertiesReader(caminhoPrefixo).readProps().getProperty("debug"));
        if (debug) System.out.println(texto);
        ReportPortal.emitLog(texto, "INFO", Date.from(Instant.now()));
    };

    Function<ServiceSpecs, ServiceResponse> get_withoutCache = (specs) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .GET()
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        return response;
    };

    Function<ServiceSpecs, ServiceResponse> post_withoutCache = (specs) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .POST(HttpRequest.BodyPublishers.ofString(specs.getBody()))
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        return response;
    };

    BiConsumer<ServiceSpecs, String> get = (specs, identificador) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .GET()
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        Cache.chamadas.get(identificador).setServiceResponse(response);
    };

    BiConsumer<ServiceSpecs, String> post = (specs, identificador) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .POST(HttpRequest.BodyPublishers.ofString(specs.getBody()))
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        Cache.chamadas.get(identificador).setServiceResponse(response);
    };

    BiConsumer<ServiceSpecs, String> postFormData = (specs, identificador) -> {
        specs.header.put("Content-Type", "application/x-www-form-urlencoded");

        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .POST(BodyPublisherUtils.ofFormData(specs.getFormData()))
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        Cache.chamadas.get(identificador).setServiceResponse(response);
    };

    BiConsumer<ServiceSpecs, String> patch = (specs, identificador) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .method("PATCH", HttpRequest.BodyPublishers.ofString(specs.getBody()))
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        Cache.chamadas.get(identificador).setServiceResponse(response);
    };

    BiConsumer<ServiceSpecs, String> delete = (specs, identificador) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .DELETE()
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        Cache.chamadas.get(identificador).setServiceResponse(response);
    };

    BiConsumer<ServiceSpecs, String> put = (specs, identificador) -> {
        log.accept(specs.toString());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(specs.getUrl().concat(specs.getStringParam())))
                .headers(specs.getHeaderList())
                .header("app-token", UriProperties.token)
                .PUT(HttpRequest.BodyPublishers.ofString(specs.getBody()))
                .build();
        ServiceResponse response = BaseResponse.response.apply(request);
        log.accept(response.toString());
        Cache.chamadas.get(identificador).setServiceResponse(response);
    };


    Function<HashMap<String, String>, String> paramBuilder = (hash) -> {

        Iterator<Map.Entry<String, String>> iter = hash.entrySet().iterator();
        String url = "";

        if (!iter.hasNext()) return url;
        StringBuilder composition = new StringBuilder();
        composition.append(url).append("?");

        while (iter.hasNext()) {
            Map.Entry<String, String> temp = iter.next();
            String key = temp.getKey();
            String value = temp.getValue() == null || temp.getValue().equals("null") ? "" : String.valueOf(temp.getValue());
            if (!value.equals("")) {
                composition.append(composition.substring(composition.length() - 1).equals("?") ? "" : "&");
                composition.append(key).append("=").append(value);
            }
        }
        return composition.toString();
    };

}
