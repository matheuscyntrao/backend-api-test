package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_CamposBeneficiario_Opcoes {
    private Integer codigoCampo;
    private String texto;
    private String valor;
}
