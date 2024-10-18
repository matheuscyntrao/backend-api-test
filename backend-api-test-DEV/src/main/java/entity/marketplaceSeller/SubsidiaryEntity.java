package entity.marketplaceSeller;

import lombok.Data;

@Data
public class SubsidiaryEntity {
    private Integer idFilialMarketplace;
    private Integer idHubMarketplace;
    private Integer codigoFilial;
    private String confirmaEstoque;
    private String expedeMercadoria;
    private Integer percentualEstoque;
    private Integer qtdMinimaEstoque;
    private String dataDesativacao;
}
