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
public class PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_CamposPaciente {
    private Integer codigoCampo;
    private String campo;
    private String nomeExibicao;
    private String entidade;
    private String tipo;
    private String descricao;
    private String exibicao;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_CamposBeneficiario_Opcoes> opcoes;
}
