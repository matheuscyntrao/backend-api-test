package utils.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Function;

public interface BaseResponse {
    Function<HttpRequest, ServiceResponse> response = (request) -> {

        ServiceResponse zmResponse = new ServiceResponse();
        zmResponse.setInicio(LocalDateTime.now());
        HttpResponse<String> response = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            response = BaseService.client.get().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            zmResponse.setError(e.getCause().toString().concat("\n")
                    .concat(e.getStackTrace().toString()));
        }
        zmResponse.setFim(LocalDateTime.now());
        zmResponse.setTime(ChronoUnit.MILLIS.between(zmResponse.getInicio(), zmResponse.getFim()));
        zmResponse.setHeader(response.headers());
        zmResponse.setStatusCode(response.statusCode());
        zmResponse.setBody(response.body());

        return zmResponse;
    };

}
