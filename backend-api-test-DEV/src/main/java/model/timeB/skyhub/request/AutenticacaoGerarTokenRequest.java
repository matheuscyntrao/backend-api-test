package model.timeB.skyhub.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AutenticacaoGerarTokenRequest {
    private String user_email;
    private String api_key;
}
