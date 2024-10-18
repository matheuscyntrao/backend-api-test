package utils.service;

import com.epam.reportportal.service.ReportPortal;

import java.sql.Date;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static java.lang.Thread.currentThread;

public interface BuilderRequest {

    BiConsumer<String, Object> body = (rota, body) -> {
        ServiceSpecs specs = new ServiceSpecs();
        specs.setBody(JsonToString.objectToJsonString.apply(body));
        ServiceCache cache = new ServiceCache();
        cache.setServiceSpecs(specs);
        try {
            Cache.chamadas.get(rota).getServiceSpecs().setBody(body);
        } catch (Exception e) {
            Cache.chamadas.put(rota, cache);
        }
    };

    Consumer<String> simple = (rota) -> {
        ServiceSpecs specs = new ServiceSpecs();
        ServiceCache cache = new ServiceCache();
        cache.setServiceSpecs(specs);
        try {
            Cache.chamadas.get(rota).setServiceSpecs(specs);
        } catch (Exception e) {
            Cache.chamadas.put(rota, cache);
        }
    };

    BiConsumer<String, Map<String, String>> path = (rota, path) -> {
        Map<String, String> pathFinal = new HashMap<>();
        Iterator it = path.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            if (pairs.getValue() == null) {
                pathFinal.put(pairs.getKey().toString(), "");
            } else {
                pathFinal.put(pairs.getKey().toString(), pairs.getValue().toString());
            }
        }

        ReportPortal.emitLog(path.toString(), "INFO", Date.from(Instant.now()));
        ServiceSpecs specs = new ServiceSpecs();
        specs.path.putAll(pathFinal);
        ServiceCache cache = new ServiceCache();
        cache.setServiceSpecs(specs);
        try {
            Cache.chamadas.get(rota).getServiceSpecs().path.putAll(pathFinal);
        } catch (Exception e) {
            Cache.chamadas.put(rota, cache);
        }
    };

    BiConsumer<String, Map<String, String>> param = (rota, param) -> {
        ReportPortal.emitLog(param.toString(), "INFO", Date.from(Instant.now()));
        ServiceSpecs specs = new ServiceSpecs();
        specs.param.putAll(param);
        ServiceCache cache = new ServiceCache();
        cache.setServiceSpecs(specs);
        try {
            Cache.chamadas.get(rota).getServiceSpecs().param.putAll(param);
        } catch (Exception e) {
            Cache.chamadas.put(rota, cache);
        }
    };

    BiConsumer<String, Map<String, String>> header = (rota, header) -> {
        ReportPortal.emitLog(header.toString(), "INFO", Date.from(Instant.now()));
        ServiceSpecs specs = new ServiceSpecs();
        specs.header.putAll(header);
        ServiceCache cache = new ServiceCache();
        cache.setServiceSpecs(specs);
        try {
            Cache.chamadas.get(rota).getServiceSpecs().header.putAll(header);
        } catch (Exception e) {
            Cache.chamadas.put(rota, cache);
        }
    };
}
