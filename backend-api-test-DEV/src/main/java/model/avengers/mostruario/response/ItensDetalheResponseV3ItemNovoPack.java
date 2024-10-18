package model.avengers.mostruario.response;

import lombok.Data;

@Data
public class ItensDetalheResponseV3ItemNovoPack {
    private Integer codigo;
    private String descricao;
    private String dataInicial;
    private String dataFinal;
    private String descricaoCategoria;
    private String descricaoTag;
    private String descricaoSite;
    private String descricaoModalidade;
    private Integer quantidadeCompra;
    private Boolean bemPanvel;

}
