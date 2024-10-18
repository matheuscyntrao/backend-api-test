package model.domino.order.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostEcommerceOrderRequest_v1_Item {
    private Boolean advanceSale;
    private Long amount;
    private PostEcommerceOrderRequest_v1_Cassi cassi;
    private Long code;
    private Boolean contemplatedByCovenant;
    private Long deliveryAmount;
    private Long deliveryId;
    private PostEcommerceOrderRequest_v1_Item_Discount discount;
    private Long discountCouponCode;
    private PostEcommerceOrderRequest_v1_Item_DistributorOrder distributorOrder;
    private Long exemptionPercentage;
    private Long iavCode;
    private Long liberatorCode;
    private Long lot;
    private Long number;
    private PostEcommerceOrderRequest_v1_Item_Pack pack;
    private List<PostEcommerceOrderRequest_v1_Item_PbmAuthorizations> pbmAuthorizations;
    private PostEcommerceOrderRequest_v1_Item_Prescription prescription;
    private PostEcommerceOrderRequest_v1_Item_Promotion promotion;
    private Long stockAmount;
    private BigDecimal totalValue;
    private BigDecimal unitaryValue;
}
