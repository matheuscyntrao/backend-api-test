package model.coupon.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCouponWalletPromocodeV1Request {
    private String channel;
    private String customerCpf;
    private String promocode;
}
