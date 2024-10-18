package model.coupon.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCouponWalletV1Response<expireDate> {
    private Boolean automaticApplyInCart;
    private BigDecimal bonusPercentage;
    private BigDecimal bonusValue;
    private Long couponAvailable;
    private Long couponId;
    private Long couponUses;
    private String description;
    private String detailedDescription;
    private BigDecimal discountPercentage;
    private String discountType;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expireDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime includeDate;
    private List<Long> itemsId;
    private String originAssignment;
    private String promocode;
    private String rules;
    private String title;
    private Long walletId;
    private Long walletUses;
}
