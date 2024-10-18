package utils.service;

import com.epam.reportportal.service.ReportPortal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.net.http.HttpHeaders;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ServiceResponse {
    private Integer statusCode = 0;
    public HttpHeaders header;
    public String body = "";
    private String error = "";
    private Long time = 0L;
    private LocalDateTime inicio = LocalDateTime.now();
    private LocalDateTime fim = LocalDateTime.now();

    @Override
    public String toString() {
        return "\nstatusCode: " + statusCode +
                "\nstart: " + inicio +
                "\nend:   " + fim +
                "\ntime:  " + time +
                "\n\nheader:  \n" + header.map().toString() +
                "\n\nbody:    \n" + getBody() +
                "\n\nerror:   \n" + error +
                "\n";
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public HttpHeaders getHeader() {
        return header;
    }

    public void setHeader(HttpHeaders header) {
        this.header = header;
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportPortal.emitLog(e.getMessage(), "ERROR", Date.from(Instant.now()));
        }
        return mappedBody;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }
}
