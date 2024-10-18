package model.coupon.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import utils.json.LocalDateTimeDeserializer;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCouponData_v1Response {
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
    private Double bonusValue;
    private Double minimumValue;
    private Double discountPercentage;
    private Double price;
    private Double rebatePercentage;
    private Double rebateValue;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime creationDate;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime alterationDate;
    private Boolean active;
}
