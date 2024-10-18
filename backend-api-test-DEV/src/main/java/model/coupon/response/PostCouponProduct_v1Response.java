package model.coupon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCouponProduct_v1Response {
    private int id;
    private int couponId;
    private String columnName;
    private String columnType;
    private String relationalOperator;
    private String columnValue;
}