package model.timeB.skyhub.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderQueueResponseItems {
    @JsonProperty("special_price")
    private Double specialPrice;
    @JsonProperty("shipping_cost")
    private Double shippingCost;
    @JsonProperty("sale_fee")
    private String saleFee;
    @JsonProperty("remote_store_id")
    private String remoteStoreId;
    private Integer qty;
    @JsonProperty("product_id")
    private String productId;
    @JsonProperty("original_price")
    private Double originalPrice;
    private String name;
    @JsonProperty("listing_type_id")
    private String listingTypeId;
    private String id;
    @JsonProperty("gift_wrap")
    private String giftWrap;
    private String detail;
}