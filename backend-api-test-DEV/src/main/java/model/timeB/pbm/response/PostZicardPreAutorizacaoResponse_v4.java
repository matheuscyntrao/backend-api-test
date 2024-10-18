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
public class PostZicardPreAutorizacaoResponse_v4 {
    private String numeroSessao;
    private String nsuPreAutorizacao;
    private String identificadorTransacao;
    private Boolean statusPreAutorizacao;
    private PostZicardPreAutorizacaoResponse_v4_DesvioFluxo desvioFluxo;
    private PostZicardPreAutorizacaoResponse_v4_DesvioFluxoOffline desvioFluxoOffline;
    private List<PostZicardPreAutorizacaoResponse_v4_Itens> itens;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensRejeitados> itensRejeitados;
    private List<PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo> itensDesvioFluxo;
    private PostZicardPreAutorizacaoResponse_v4_FormaPagamento formaPagamento;
    private List<PostZicardPreAutorizacaoResponse_v4_Pacientes> pacientes;
    private Boolean solicitaReceita;
    private PostZicardPreAutorizacaoResponse_v4_TextoDosTermosOptin textoDosTermosOptin;
}
