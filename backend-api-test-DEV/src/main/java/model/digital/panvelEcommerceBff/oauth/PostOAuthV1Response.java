package model.digital.panvelEcommerceBff.oauth;

import lombok.Data;

@Data
public class PostOAuthV1Response {
    private String access_token;
    private String expires_in;
    private String jti;
    private String refresh_token;
    private String scope;
    private String token_type;
}
