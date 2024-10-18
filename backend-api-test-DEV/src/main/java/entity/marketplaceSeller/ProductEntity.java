package entity.marketplaceSeller;

import lombok.Data;

@Data
public class ProductEntity {
    private String codigoItem;
    private Double weight;
    private Double height;
    private Double width;
    private Double length;
    private String dataDeExclusao;
    private String descDetalhadaMarketplace;
    private String itemBloqueado;
}
