package model.timeB.pbmGatewayService.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields {
    private String code;
    private String exhibition;
    private String name;
    private String type;
    private Integer maxLenght;
    private String maskInput;
    private String entity;
    private List<PostPreAutorizacaoResponse_v1_deviationFlux_formAccess_fields_options> options;
}
