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
public class PostFuncionalAutorizacaoResponse_v4 {
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private String tipoRetornoSolicitacao;
    private String mensagemRetorno;
    private Long numeroCartao;
    private Boolean statusAutorizacao;
    private List<PostFuncionalAutorizacaoResponse_v4_Item> itens;
    private PostFuncionalAutorizacaoResponse_v4_FormaPagamento formaPagamento;
    private List<PostFuncionalAutorizacaoResponse_v4_SolicitacoesMedicamentos> solicitacoesMedicamentos;
}
