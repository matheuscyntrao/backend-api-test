package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigInteger;

@Data
public class ShippingPickupResponse_v1_Store_StockDeviation {
    private String originStockDeviation;
    private String deliveryDateCD;
    private Integer distributionLogistics;
}
