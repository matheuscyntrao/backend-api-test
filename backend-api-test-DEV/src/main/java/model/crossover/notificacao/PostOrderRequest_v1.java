package model.crossover.notificacao;

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
public class PostOrderRequest_v1 {
    private List<PostOrderRequest_v1_Item> items;
    private PostOrderRequest_v1_Delivery delivery;
    private Long orderId;
    private String status;
    private Long shoppingCartId;
    private BigDecimal orderTotalValue;
    private Integer subsidiary;
    private Boolean urgentOrder;
    private String orderType;
    private String orderSource;
    private Integer operationCode;
    private Long signatureId;
    private List<PostOrderRequest_v1_Covenants> covenants;
    private PostOrderRequest_v1_Client client;
    private List<PostOrderRequest_v1_PaymentMethod> paymentMethods;
    private PostOrderRequest_v1_FeeItem feeItem;
    private Boolean splittedOrder;
    private String nitEsitef;

}
