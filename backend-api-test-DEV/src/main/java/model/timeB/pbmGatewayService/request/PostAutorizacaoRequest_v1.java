package model.timeB.pbmGatewayService.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostAutorizacaoRequest_v1 {
    private String identificadorTransacao;
}
