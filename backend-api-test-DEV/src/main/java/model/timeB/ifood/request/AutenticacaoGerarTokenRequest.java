package model.timeB.ifood.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AutenticacaoGerarTokenRequest {
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("client_id")
    private String clientId;
}
