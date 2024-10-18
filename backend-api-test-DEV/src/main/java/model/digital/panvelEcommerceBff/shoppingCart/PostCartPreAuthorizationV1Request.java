package model.digital.panvelEcommerceBff.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.shoppingCart.orm.Item;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCartPreAuthorizationV1Request {
    private String beneficiary;
    private String card;
    private String codeAdmCovenant;
    private String cpf;
    private List<Item> items;
}
