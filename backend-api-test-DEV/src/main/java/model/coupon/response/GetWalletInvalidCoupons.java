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
public class GetWalletInvalidCoupons {
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
    private LocalDateTime endDate;//Data final de validade do cupom - example: 20/01/2020 00:00:00
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime expireDate;//Data final de validade da carteira - example: 20/01/2020 00:00:00
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime includeDate;//Data inicial de atribuição da carteira - example: 20/01/2020 00:00:00
    private List<Long> itemsId;
    private Long mainItemId;
    private String originAssignment;
    private String promocode;
    private String rules;
    private String title;
    private Long walletId;
    private Long walletUses;
}
