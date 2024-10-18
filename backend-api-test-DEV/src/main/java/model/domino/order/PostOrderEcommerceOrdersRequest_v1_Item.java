package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Item {
    private Boolean advanceSale;
    private Long amount;
    private PostOrderEcommerceOrdersRequest_v1_Cassi cassi;
    private Long code;
    private Boolean contemplatedByCovenant;
    private Long deliveryAmount;
    private Long deliveryId;
    private PostOrderEcommerceOrdersRequest_v1_Item_Discount discount;
    private Long discountCouponCode;
    private PostOrderEcommerceOrdersRequest_v1_Item_DistributorOrder distributorOrder;
    private Long exemptionPercentage;
    private Long iavCode;
    private Long liberatorCode;
    private Long lot;
    private Long number;
    private PostOrderEcommerceOrdersRequest_v1_Item_Pack pack;
    private PostOrderEcommerceOrdersRequest_v1_Item_Pbm pbm;
    private PostOrderEcommerceOrdersRequest_v1_Item_Prescription prescription;
    private PostOrderEcommerceOrdersRequest_v1_Item_Promotion promotion;
    private Long stockAmount;
    private BigDecimal totalValue;
    private BigDecimal unitaryValue;
}
