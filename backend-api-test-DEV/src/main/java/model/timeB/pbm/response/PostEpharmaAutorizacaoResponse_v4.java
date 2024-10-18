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
public class PostEpharmaAutorizacaoResponse_v4 {
    private String numeroSessao;
    private String nsuPreAutorizacao;
    private String identificadorTransacao;
    private Boolean statusPreAutorizacao;
    private PostEpharmaPreAutorizacaoResponse_v4_DesvioFluxo desvioFluxo;
    private PostEpharmaPreAutorizacaoResponse_v4_DesvioFluxoOffLine desvioFluxoOffLine;
    private List<PostEpharmaPreAutorizacaoResponse_v4_Item> itens;
    private List<PostEpharmaPreAutorizacaoResponse_v4_Item> itensRejeitados;
    private List<PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo> itensDesvioFluxo;
    private PostEpharmaPreAutorizacaoResponse_v4_FormaPagamento formaPagamento;
    private List<PostEpharmaPreAutorizacaoResponse_v4_Pacientes> pacientes;
    private Boolean solicitaReceita;
    private PostEpharmaPreAutorizacaoResponse_v4_TextoDosTermosOptin textoDosTermosOptin;
}
