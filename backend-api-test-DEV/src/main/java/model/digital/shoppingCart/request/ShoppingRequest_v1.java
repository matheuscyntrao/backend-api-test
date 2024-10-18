package model.digital.shoppingCart.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingRequest_v1 {
    private String channel;
    private Integer codCustomer;
    private Integer shoppingCartId;
    private Integer subsidiaryCode;
}
