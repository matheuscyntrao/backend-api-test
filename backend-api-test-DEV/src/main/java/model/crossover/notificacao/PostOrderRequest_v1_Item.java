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
public class PostOrderRequest_v1_Item {
    private Long code;
    private PostOrderRequest_v1_Item_Discount discount;
    private String contemplatedByCovenant;
    private Integer number;
    private String deliveryId;
    private BigDecimal amount;
    private BigDecimal deliveryAmount;
    private BigDecimal unitaryValue;
    private BigDecimal totalValue;
    private Double exemptionPercentage;
    private PostOrderRequest_v1_Item_Promotion promotion;
    private List<String> pbmAuthorizations;
    private Boolean typedItem;
}
