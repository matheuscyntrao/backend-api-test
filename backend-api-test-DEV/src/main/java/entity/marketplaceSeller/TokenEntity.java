package entity.marketplaceSeller;

import lombok.Data;

@Data
public class TokenEntity {
    private String userEmail;
    private String apiKey;
    private String accountmanagerKey;
    private String bearerToken;
    private String expiracaoToken;
    private String dataLogin;
}
