package model.coupon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PutCouponData_v1Response {
    private BigInteger id;
    private String description;
    private String detailedDescription;
    private BigInteger idCampaign;
    private Boolean pub;
    private Boolean cuponable;
    private BigInteger limitUses;
    private BigInteger individualUses;
    private String title;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;

    private BigInteger durationDays;
    private String promocode;
    private Boolean dynamicPromocode;
    private BigInteger discountType;
    private BigDecimal bonusValue;
    private BigDecimal minimumValue;
    private BigInteger discountPercentage;
    private BigInteger price;
    private BigDecimal rebatePercentage;
    private BigDecimal rebateValue;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime alterationDate;
    private Boolean active;
}
