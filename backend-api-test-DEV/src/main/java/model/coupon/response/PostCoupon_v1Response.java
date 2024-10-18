package model.coupon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostCoupon_v1Response{
    private PostCouponData_v1Response couponData;
    private List<GetCouponProductByCouponId_v1Response> couponProducts;
    private List<GetCouponCoverageByCouponId_v1Response> couponCoverages;
    private List<GetCouponCustomerByCouponId_v1Response> couponCustomers;
}
