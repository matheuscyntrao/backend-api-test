package model.digital.panvelEcommerceBff.cashPayment.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.CartTotals;
import model.digital.panvelEcommerceBff._orm.Convenance;
import model.digital.panvelEcommerceBff.cashPayment.response.orm.*;

import java.util.List;

@Data
public class PatchPaymentCashV1Response {
    private CartTotals cartTotals;
    private String channel;
    private Long codCupomdeOfertas;
    private List<Convenance> convenance;
    private Customer customer;
    private Long customerCode;
    private Deliveries deliveries;
    private List<Items> items;
    private String orderType;
    private Payments payments;
    private String shoppingCartCreation;
    private String shoppingCartId;
    private Subsidiary subsidiary;
    private Long subsidiaryCode;
}
