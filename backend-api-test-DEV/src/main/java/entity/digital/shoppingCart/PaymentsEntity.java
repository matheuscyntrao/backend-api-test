package entity.digital.shoppingCart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Data
@Entity("Payments")
public class PaymentsEntity {
    @Id
    private ObjectId id;
    private PaymentsEntity_Payment payments[];
}

@Data
class PaymentsEntity_Payment {
    private Integer paymentCode;
    private String paymentDescription;
    private Boolean useOnSale;
    private Boolean cashPayment;
    private Boolean companyCovenant;
    private Boolean rearCashPayment;
    private Boolean allowsDiscount;
    private Boolean useOnAloPanvel;
    private Boolean allowsRepetition;
    private Boolean allowsWithdrawal;
    private Boolean integralWithdrawal;
    private Boolean allowsChange;
    private String conciliateInstallmentSale;
    private Boolean useOnInternet;
    private Boolean updateCashBalance;
    private Boolean useOnMobileSale;
    private Boolean doesNotPrintTefCopy;
    private Boolean printsOnlyTefCustomerCopy;
    private Boolean printsOnlyTefStoreCopy;
    private Boolean asksIfCustomerWantsTefDuplicate;
    private String payment;
}