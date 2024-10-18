package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDetail {
    private Convenant covenant;
    private GiftCoupon giftCoupon;
    private Pack pack;
    private Pbm pbm;
    private Promotion promotion;
    private TaxRules taxRules;
}
