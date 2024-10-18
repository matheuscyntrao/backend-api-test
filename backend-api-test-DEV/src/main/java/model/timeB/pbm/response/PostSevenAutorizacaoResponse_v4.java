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
public class PostSevenAutorizacaoResponse_v4 {
    private String numeroSessao;
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private Boolean statusAutorizacao;
    private String solicitaReceita;
    private List<PostZicardAutorizacaoResponse_v4_Itens> itens;
    private List<PostZicardPreAutorizacaoResponse_v4_Pacientes> pacientes;
    private List<PostSevenAutorizacaoResponse_v4_FormaPagamento> formaPagamento;
}
