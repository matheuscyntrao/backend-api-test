package model.coupon.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCouponData_v1Request {
    private BigDecimal bonusValue;
    private String cuponable;
    private String description;
    private String detailedDescription;
    private BigDecimal discountPercentage;
    private String discountType;
    private String durationDays;
    private String dynamicPromocode;
    private String endDate;
    private String idCampaign;
    private String individualUses;
    private String limitUses;
    private String minimumValue;
    private BigDecimal price;
    private String promocode;
    private String pub;
    private BigDecimal rebateValue;
    private BigDecimal rebatePercentage;
    private String startDate;
    private String active;
    private String title;
}
