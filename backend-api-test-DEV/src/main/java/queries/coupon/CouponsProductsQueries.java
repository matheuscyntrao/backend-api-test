package queries.coupon;

import com.epam.reportportal.service.ReportPortal;
import model.coupon.response.GetCouponProductByCouponId_v1Response;
import model.coupon.response.PostCouponProduct_v1Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.PostGresBaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class CouponsProductsQueries extends PostGresBaseQueries {

    public static List<PostCouponProduct_v1Response> getCouponsItemsById(Integer id) {
        String SQL = "select id, coupon_id couponId, column_name columnName, column_type columnType, relational_operator relationalOperator, column_value columnValue "
                    + " from coupon.coupon_product WHERE id = " + id;

        List<PostCouponProduct_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PostCouponProduct_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<GetCouponProductByCouponId_v1Response> getCouponsItemsByCouponId(Integer couponId) {
        String SQL = "select id, coupon_id couponId, column_name columnName, column_type columnType, relational_operator relationalOperator, column_value columnValue "
                    + " from coupon.coupon_product WHERE coupon_id = " + couponId;
        List<GetCouponProductByCouponId_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(GetCouponProductByCouponId_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

}
