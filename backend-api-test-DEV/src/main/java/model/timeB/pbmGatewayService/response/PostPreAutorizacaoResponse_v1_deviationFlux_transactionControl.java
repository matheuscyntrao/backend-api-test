package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl {
    private List<PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl_fields> values;
    private String propertyName;
}
