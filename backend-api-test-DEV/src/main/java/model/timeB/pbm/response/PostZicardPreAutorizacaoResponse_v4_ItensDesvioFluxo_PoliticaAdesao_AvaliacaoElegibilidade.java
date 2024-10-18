package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostZicardPreAutorizacaoResponse_v4_ItensDesvioFluxo_PoliticaAdesao_AvaliacaoElegibilidade {
    private Boolean existeProdutoPrograma;
    private Boolean requisitarCadastroPrograma;
    private Boolean requisitarCadastroProduto;
    private Integer codigoPrograma;
    private Integer codigoProdutoRegra;
    private String descricaoPrograma;
    private String descricaoProduto;
}
