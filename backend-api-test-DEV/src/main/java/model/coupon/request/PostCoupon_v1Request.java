package model.coupon.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCoupon_v1Request {
    private PostCouponData_v1Request couponData;
    private List<PostAndPutCouponProduct_v1Request> couponProducts;
    private List<PostAndPutCouponCoverage_v1Request> couponCoverages;
    private List<PostAndPutCouponCustomer_v1Request> couponCustomers;
}
