package model.digital.panvelEcommerceBff.itemDetail.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pack {
     private BigDecimal dealPrice;
     private String description;
     private Long quantity;
}
