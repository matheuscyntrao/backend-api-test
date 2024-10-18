package queries.coupon;

import com.epam.reportportal.service.ReportPortal;
import model.coupon.response.GetCouponCustomerByCouponId_v1Response;
import model.coupon.response.PostCouponCustomer_v1Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.PostGresBaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class CouponsCustomerQueries extends PostGresBaseQueries {
    public static List<PostCouponCustomer_v1Response> getCouponsCustomersById(Integer id) {
        String SQL = "SELECT id, coupon_id couponId, column_name columnName, column_type columnType, relational_operator relationalOperator, column_value columnValue\n" +
                "FROM coupon.coupon_customer WHERE id = " + id;
        List<PostCouponCustomer_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PostCouponCustomer_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<GetCouponCustomerByCouponId_v1Response> getCouponsCustomerByCouponId(Integer couponId) {
        String SQL = "select id, coupon_id couponId, column_name columnName, column_type columnType, relational_operator relationalOperator, column_value columnValue FROM coupon.coupon_customer WHERE coupon_customer.coupon_id = " + couponId;
        List<GetCouponCustomerByCouponId_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(GetCouponCustomerByCouponId_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<PostCouponCustomer_v1Response> getCouponsCustomersResult = getCouponsCustomersById(48);
        System.out.println(getCouponsCustomersResult);
    }
}
