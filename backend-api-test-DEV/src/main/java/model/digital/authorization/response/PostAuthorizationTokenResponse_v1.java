package model.digital.authorization.response;

import lombok.Data;

@Data
public class PostAuthorizationTokenResponse_v1 {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
    private String scope;
    private String jti;
}
