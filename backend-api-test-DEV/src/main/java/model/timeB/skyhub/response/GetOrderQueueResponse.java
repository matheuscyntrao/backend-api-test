package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class GetOrderQueueResponse {
    @JsonProperty("billing_address")
    private GetOrderQueueResponseBillingAddress billingAddress;
    private Double discount;
    @JsonProperty("sync_sale_system")
    private String syncSaleSystem;
    private GetOrderQueueResponseCustomer customer;
    @JsonProperty("target_order")
    private String targetOrder;
    private List invoices;
    @JsonProperty("total_ordered")
    private Double totalOrdered;
    @JsonProperty("estimated_delivery_shift")
    private String estimatedDeliveryShift;
    @JsonProperty("shipping_cost")
    private Double shippingCost;
    private Double interest;
    private List<GetOrderQueueResponseItems> items;
    private String code;
    @JsonProperty("shipping_carrier")
    private String shippingCarrier;
    @JsonProperty("sync_status")
    private String syncStatus;
    private GetOrderQueueResponseStatus status;
    @JsonProperty("calculation_type")
    private String calculationType;
    @JsonProperty("seller_shipping_cost")
    private Double sellerShippingCost;
    private List payments;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("estimated_delivery")
    private String estimatedDelivery;
    @JsonProperty("exported_at")
    private String exportedAt;
    @JsonProperty("shipping_address")
    private GetOrderQueueResponseShippingAddress shippingAddress;
    @JsonProperty("import_info")
    private GetOrderQueueResponseImportInfo importInfo;
    @JsonProperty("expedition_limit_date")
    private String expeditionLimitDate;
    @JsonProperty("shipping_method_id")
    private String shippingMethodId;
    @JsonProperty("placed_at")
    private String placedAt;
    @JsonProperty("shipping_estimate_id")
    private String shippingEstimateId;
    @JsonProperty("shipped_date")
    private String shippedDate;
    @JsonProperty("shipping_method")
    private String shippingMethod;
    private String channel;
    @JsonProperty("approved_date")
    private String approvedDate;
    @JsonProperty("delivered_date")
    private String deliveredDate;
    @JsonProperty("imported_at")
    private String importedAt;
    @JsonProperty("delivery_contract_type")
    private String deliveryContractType;
    private List tags;
    @JsonProperty("linked_order")
    private String linkedOrder;
    private List shipments;
}