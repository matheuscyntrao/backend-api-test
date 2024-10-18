package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEpharmaPreAutorizacaoResponse_v4_ItemDesvioFluxo_PoliticaAdesao_AvaliacaoElegibilidade {
    private Boolean existeProdutoPrograma;
    private Integer codigoPrograma;
    private String descricaoPrograma;
    private Integer codigoProdutoRegra;
    private String descricaoProduto;
    private Boolean requisitarCadastroPrograma;
    private Boolean requisitarCadastroProduto;
}
