package model.digital.panvelEcommerceBff.shoppingCart.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDetail {
    private String cvv;
    private String dataValidade;
    private String numeroCartao;
    private String titular;
}
