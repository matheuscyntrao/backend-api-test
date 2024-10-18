package utils.service;

import java.net.http.HttpClient;
import java.util.function.Supplier;

public interface BaseService {

    Supplier<HttpClient> client = () -> {
        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();
    };

}
