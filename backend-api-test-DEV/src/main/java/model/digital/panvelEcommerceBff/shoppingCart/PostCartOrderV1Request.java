package model.digital.panvelEcommerceBff.shoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.shoppingCart.orm.CardPayment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCartOrderV1Request {
    private CardPayment cardPayment;
    private Long codigoSituacaoPedido;
    private String dddRastreio;
    private String imprimeDocumentoCupom;
    private String imprimeNfe;
    private String telefoneRastreio;
}
