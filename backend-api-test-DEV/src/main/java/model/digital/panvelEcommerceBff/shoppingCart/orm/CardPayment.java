package model.digital.panvelEcommerceBff.shoppingCart.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardPayment {
    private CardDetail cardDetail;
    private StoredCard storedCard;
}
