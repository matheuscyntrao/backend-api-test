package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1_textTermsOptin {
    private String codeSend;
    private String linkTerms;
    private String message;
    private String status;
    private String textTerms;
}
