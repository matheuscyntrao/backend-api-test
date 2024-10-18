package model.timeB.pbmGatewayService.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.timeB.pbmGatewayService.response.PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostAdesaoFuncionalRequest_v1 {
    private List<PostAdesaoFuncionalRequest_v1_Fields> fields;
    private List<PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl> fieldsControl;
    private PostAdesaoRequest_v1_CustomerData customerData;
}
