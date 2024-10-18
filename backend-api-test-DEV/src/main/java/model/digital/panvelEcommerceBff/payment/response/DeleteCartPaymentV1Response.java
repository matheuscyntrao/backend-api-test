package model.digital.panvelEcommerceBff.payment.response;

import lombok.Data;
import model.digital.panvelEcommerceBff._orm.CartTotals;
import model.digital.panvelEcommerceBff._orm.Convenance;
import model.digital.panvelEcommerceBff.cashPayment.response.orm.*;

import java.util.List;

@Data
public class DeleteCartPaymentV1Response {
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
