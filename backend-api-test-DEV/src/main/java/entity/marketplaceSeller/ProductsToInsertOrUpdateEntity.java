package entity.marketplaceSeller;

import lombok.Data;

@Data
public class ProductsToInsertOrUpdateEntity {
    private Integer codigo_do_item;
    private Integer id_hub_marketplace;
    private String acao;
}
