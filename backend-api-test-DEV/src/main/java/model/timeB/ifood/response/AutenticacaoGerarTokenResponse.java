package model.timeB.ifood.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class AutenticacaoGerarTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private String expiresIn;
}




