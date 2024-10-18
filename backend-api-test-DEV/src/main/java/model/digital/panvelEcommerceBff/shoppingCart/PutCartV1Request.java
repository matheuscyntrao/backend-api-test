package model.digital.panvelEcommerceBff.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutCartV1Request {
    private String channel;
    private Long customerCode;
    private String shoppingCartId;
    private Long subsidiaryCode;
}
