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
public class PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao {
    private Boolean obrigatorioPrescritor;
    private Boolean utilizaPacientes;
    private PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_AvaliacaoElegibilidade avaliacaoElegibilidade;
    private List<PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_Pacientes> pacientes;
    private List<PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_CamposBeneficiario> camposBeneficiario;
    private List<PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_CamposBeneficiario> camposPaciente;
    private List<PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_CamposBeneficiario> camposProduto;
    private List<PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_CamposBeneficiario> camposExtras;
}
