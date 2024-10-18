package model.digital.panvelEcommerceBff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.CartTotals;
import model.digital.panvelEcommerceBff._orm.Convenance;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostAddItemsToCartV1Response {
    private CartTotals cartTotals;
    private String channel;
    private Long codCupomDeOfertas;
    private List<Convenance> convenance;
}
