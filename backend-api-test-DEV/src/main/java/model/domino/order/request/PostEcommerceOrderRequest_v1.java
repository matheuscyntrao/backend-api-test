package model.domino.order.request;

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
public class PostEcommerceOrderRequest_v1 {
    private PostEcommerceOrderRequest_v1_BillingAddress billingAddress;
    private Long budgetNumber;
    private String cardCaptureMethod;
    private PostEcommerceOrderRequest_v1_Cassi cassiRequest;
    private PostEcommerceOrderRequest_v1_Client client;
    private Long couponNumber;
    private List<PostEcommerceOrderRequest_v1_Covenant> covenants;
    private List<PostEcommerceOrderRequest_v1_Delivery> delivery;
    private List<PostEcommerceOrderRequest_v1_Item> items;
    private PostEcommerceOrderRequest_v1_Marketplace marketPlace;
    private String observation;
    private Long operationCode;
    private Long orderLiberatorCode;
    private String orderSource;
    private String orderStatus;
    private BigDecimal orderTotalValue;
    //private String orderType;
    private Boolean panvelGo;
    private List<PostEcommerceOrderRequest_v1_PaymentMethod> paymentMethods;
    private Boolean printsCouponDocument;
    private Boolean printsNfe;
    private Long resourceCode;
    private String shoppingCartId;
    private Long signatureId;
    private Long subsidiary;
    private Boolean urgentOrder;
}
