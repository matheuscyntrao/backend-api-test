package model.timeB.pbm.response;

import lombok.Data;

@Data
public class AvaliacaoEligibilidadeResponse_v4 {
    private Boolean existeProdutoPrograma;
    private Integer codigoPrograma;
    private String descricaoPrograma;
    private Integer codigoProdutoRegra;
    private String descricaoProduto;
    private Boolean requisitarCadastroPrograma;
    private Boolean requisitarCadastroProduto;
}
