package entity.ifood;

import lombok.Data;

@Data
public class BearerTokenEntity {
    private String clientSecret;
    private String clientId;
}
