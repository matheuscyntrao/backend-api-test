package model.plataforma.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostPaymentHashRequest_v1_Order {
    private BigDecimal amount;
    private PostPaymentHashRequest_v1_Order_AntiFraudClient antiFraudClient;
    private PostPaymentHashRequest_v1_Order_BillingAddress billingAddress;
    private PostPaymentHashRequest_v1_Order_DeliveryAddress deliveryAddress;
    private Long externalOrderId;
    private List<PostPaymentHashRequest_v1_Order_Item> item;
    private String telephone;
}
