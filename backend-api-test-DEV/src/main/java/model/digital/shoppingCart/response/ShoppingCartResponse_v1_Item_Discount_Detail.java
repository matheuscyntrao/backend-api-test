package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Item_Discount_Detail {
    private ShoppingCartResponse_v1_Item_Discount_Detail_Pack pack;
    private ShoppingCartResponse_v1_Item_Discount_Detail_Promotion promotion;
    private ShoppingCartResponse_v1_Item_Discount_TaxRule taxRule;
    private ShoppingCartResponse_v1_Item_Discount_Detail_Pbm pbm;
    private ShoppingCartResponse_v1_Item_Discount_Detail_GiftCoupon giftCoupon;
    private ShoppingCartResponse_v1_Item_Discount_Detail_Covenant covenant;

}
