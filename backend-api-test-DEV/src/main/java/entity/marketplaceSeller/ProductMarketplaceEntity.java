package entity.marketplaceSeller;

import lombok.Data;

@Data
public class ProductMarketplaceEntity {
    private Integer idItemMarketplace;
    private Integer idHubMarketplace;
    private Integer codigoItem;
    private String dataInclusao;
    private String dataExclusao;
}
