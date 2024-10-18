package model.timeB.pbmGatewayService.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCancelamentoRequest_v1 {
    private String transactionIdentifier;
}
