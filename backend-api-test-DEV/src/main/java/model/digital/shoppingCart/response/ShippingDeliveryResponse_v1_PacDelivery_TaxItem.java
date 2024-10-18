package model.digital.shoppingCart.response;

import lombok.Data;

import java.util.List;

@Data
public class ShippingDeliveryResponse_v1_PacDelivery_TaxItem {
      private Long taxCode;
      private Integer quantity;
      private String shippingType;
      private Double taxValue;
}
