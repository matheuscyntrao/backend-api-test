package model.coupon.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCouponWalletV1Request {
    private String channel;
    private Long couponId;
    private Integer customerCpf;
    private String origin;
}
