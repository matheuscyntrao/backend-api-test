package model.digital.panvelEcommerceBff._orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    private Double dealPrice;
    private Double percentage;
}
