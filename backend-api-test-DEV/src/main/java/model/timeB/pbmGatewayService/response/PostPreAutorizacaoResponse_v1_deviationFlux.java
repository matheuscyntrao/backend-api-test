package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1_deviationFlux {
    private String deviationFlux;
    private String ean;
    private List<PostPreAutorizacaoResponse_v1_deviationFlux_transactionControl> transactionControl;
    private List<PostPreAutorizacaoResponse_v1_deviationFlux_formAccess> formAccess;
    private PostPreAutorizacaoResponse_v1_deviationFlux_offline offLine;
    private Long panvelCode;
    private Boolean prescriptionRequired;
    private String textInformation;
    private Boolean usePatient;
}
