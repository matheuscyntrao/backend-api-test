package model.timeB.skyhub.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDetails {
    private String channel;
    private List<OrderRequestItems> items;
    private OrderRequestCustomer customer;
    @JsonProperty("billing_address")
    private OrderRequestBillingAddress billingAddresss;
    @JsonProperty("shipping_address")
    private OrderRequestShippingAddress shippingAddress;
    private List<OrderRequestPayments> payments;
    @JsonProperty("shipping_method")
    private String shippingMethod;
    @JsonProperty("shipping_method_id")
    private String shippingMethodId;
    @JsonProperty("estimated_delivery")
    private String estimatedDelivery;
    @JsonProperty("shipping_cost")
    private Double shippingCost;
    @JsonProperty("calculation_type")
    private String calculationType;
    private Double interest;
    private Double discount;
}