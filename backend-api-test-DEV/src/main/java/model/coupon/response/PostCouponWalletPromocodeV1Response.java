package model.coupon.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCouponWalletPromocodeV1Response {
    private Boolean automaticApplyInCart;
    private BigDecimal bonusPercentage;
    private BigDecimal bonusValue;
    private Long couponAvailable;//Tipo da variável não deveria ser Boolean ?
    private Long couponId;
    private Long couponUses;
    private String description;
    private String detailedDescription;
    private BigDecimal discountPercentage;
    private String discountType;
    private String endDate;
    private String expireDate;
    private String includeDate;
    private List<Long> itemsId;
    private Long mainItemId;
    private String originAssignment;
    private String promocode;
    private String rules;
    private String title;
    private Long walletId;
    private Long walletUses;
}
