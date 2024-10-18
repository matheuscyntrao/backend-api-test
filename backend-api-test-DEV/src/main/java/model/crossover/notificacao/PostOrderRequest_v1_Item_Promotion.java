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
public class PostOrderRequest_v1_Item_Promotion {
    private Long code;
    private Integer subsidiaryCode;
}
