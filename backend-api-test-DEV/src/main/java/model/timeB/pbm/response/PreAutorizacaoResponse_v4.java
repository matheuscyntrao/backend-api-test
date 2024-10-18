package model.timeB.pbm.response;

import lombok.Data;

@Data
public class PreAutorizacaoResponse_v4 {
    private String numeroSessao;
    private String nsuPreAutorizacao;
    private String identificadorTransacao;
    private Boolean statusPreAutorizacao;
    private DesvioFluxoResponse_v4 desvioFluxo;
    private DesvioFluxoOfflineResponse_v4 desvioFluxoOffline;
    private PreAutorizacaoResponse_v4_Item itens[];
    private PreAutorizacaoResponse_v4_Item itensRejeitados[];
    private PreAutorizacaoResponse_v4_Item_DesvioFluxo itensDesvioFluxo[];
    private FormaPagamentoResponse_v4 formaPagamento;
    private PacientePreAutorizacaoResponse_v4 pacientes[];
    private Boolean solicitaReceita;
}