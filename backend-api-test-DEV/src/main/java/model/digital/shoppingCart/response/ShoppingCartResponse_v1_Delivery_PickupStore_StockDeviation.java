package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;

@Data
public class ShoppingCartResponse_v1_Delivery_PickupStore_StockDeviation {
    private String originStockDeviation;
    private String deliveryDateCD;
    private Integer distributionLogistics;
}
