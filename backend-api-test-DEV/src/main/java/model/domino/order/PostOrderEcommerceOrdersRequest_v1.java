package model.domino.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderEcommerceOrdersRequest_v1 {
    private PostOrderEcommerceOrdersRequest_v1_BillingAddress billingAddress;
    private Integer budgetNumber;
    private String cardCaptureMethod;
    private PostOrderEcommerceOrdersRequest_v1_Cassi cassiRequest;
    private PostOrderEcommerceOrdersRequest_v1_Client client;
    private Long couponNumber;
    private List<PostOrderEcommerceOrdersRequest_v1_Covenant> covenants;
    private List<PostOrderEcommerceOrdersRequest_v1_Delivery> delivery;
    private List<PostOrderEcommerceOrdersRequest_v1_Item> items;
    private PostOrderEcommerceOrdersRequest_v1_Marketplace marketPlace;
    private String observation;
    private Long operationCode;
    private Long orderLiberatorCode;
    private String orderSource;
    private String orderStatus;
    private BigDecimal orderTotalValue;
    private String orderType;
    private Boolean panvelGo;
    private List<PostOrderEcommerceOrdersRequest_v1_PaymentMethods> paymentMethods;
    private Boolean printsCouponDocument;
    private Boolean printsNfe;
    private Long resourceCode;
    private Long shoppingCartId;
    private Long signatureId;
    private Long subsidiary;
    private Boolean urgentOrder;
    private Boolean usesPanvelGo;
}
