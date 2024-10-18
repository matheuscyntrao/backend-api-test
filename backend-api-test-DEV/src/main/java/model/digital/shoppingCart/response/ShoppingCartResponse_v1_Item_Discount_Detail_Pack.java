package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Item_Discount_Detail_Pack {
    private Integer sequence;
    private Long number;
    private Long code;
    private Double valorAporteFornecedor;
    private Double valorAporteTrade;
    private Double valorAporteExtra;
    private Double percentualDesconto;
}
