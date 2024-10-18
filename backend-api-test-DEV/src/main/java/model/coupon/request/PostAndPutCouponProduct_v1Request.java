package model.coupon.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostAndPutCouponProduct_v1Request {
    private String columnName;
    private String columnType;
    private String columnValue;
    private String relationalOperator;
}
