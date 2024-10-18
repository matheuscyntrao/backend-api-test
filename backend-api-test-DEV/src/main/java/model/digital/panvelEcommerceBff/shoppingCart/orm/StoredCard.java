package model.digital.panvelEcommerceBff.shoppingCart.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoredCard {
    private String cardHash;
    private Long idCartao;
}
