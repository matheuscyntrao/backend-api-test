package model.digital.panvelEcommerceBff.itemDetail.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.Discount;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Itens {
    private Discount discountDetail;
    private String image;
    private String lin;
    private String name;
    private BigDecimal originalPrice;
    private Long panvelCode;
}
