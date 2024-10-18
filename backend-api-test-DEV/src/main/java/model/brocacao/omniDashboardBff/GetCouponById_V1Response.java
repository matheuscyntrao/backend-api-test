package model.brocacao.omniDashboardBff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.coupon.response.GetCouponCoverageByCouponId_v1Response;
import model.coupon.response.GetCouponCustomerByCouponId_v1Response;
import model.coupon.response.GetCouponProductByCouponId_v1Response;
import utils.json.LocalDateTimeDeserializer;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCouponById_V1Response {

    private Integer id;
    private String description;
    private String detailedDescription;
    private Integer idCampaign;
    private Boolean pub;
    private Boolean cuponable;
    private Integer limitUses;
    private Integer individualUses;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    private Integer durationDays;
    private String promocode;
    private Boolean dynamicPromocode;
    private Integer discountType;
    private Integer bonusValue;
    private Integer minimumValue;
    private Integer discountPercentage;
    private Integer price;
    private Integer rebatePercentage;
    private Integer rebateValue;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime alterationDate;
    private Boolean active;
    private GetCouponCoverageByCouponId_v1Response[] coverages;
    private GetCouponCustomerByCouponId_v1Response[] customers;
    private GetCouponProductByCouponId_v1Response[] products;
}
