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
public class PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao {
    private Boolean obrigatorioPrescritor;
    private Boolean utilizaPacientes;
    private PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_AvaliacaoElegibilidade avaliacaoElegibilidade;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_Pacientes> pacientes;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_CamposBeneficiario> camposBeneficiario;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_CamposPaciente> camposPaciente;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_CamposProduto> camposProduto;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_CamposExtras> camposExtras;
}
