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
public class PostFuncionalPreAutorizacaoResponse_v4 {
    private Boolean statusPreAutorizacao;
    private String identificadorTransacao;
    private String nsuPreAutorizacao;
    private List<PostFuncionalPreAutorizacaoResponse_v4_Item> itens;
    private List<PostFuncionalPreAutorizacaoResponse_v4_Item> itensRejeitados;
    private PostFuncionalPreAutorizacaoResponse_v4_FormaPagamento FormaPagamentoResponse;
    private String comprovante;

}