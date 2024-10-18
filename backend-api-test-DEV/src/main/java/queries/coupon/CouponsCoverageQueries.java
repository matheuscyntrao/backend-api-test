package queries.coupon;

import com.epam.reportportal.service.ReportPortal;
import model.coupon.response.GetCouponCoverageByCouponId_v1Response;
import model.coupon.response.GetCouponCustomerByCouponId_v1Response;
import model.coupon.response.PostCouponCoverage_v1Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.PostGresBaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class CouponsCoverageQueries extends PostGresBaseQueries {
    public static List<PostCouponCoverage_v1Response> getCouponsCoverageById(Integer id) {
        String SQL = "select id, coupon_id couponId, column_name columnName, column_type columnType, relational_operator relationalOperator, column_value columnValue from coupon.coupon_coverage WHERE id = " + id;
        List<PostCouponCoverage_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PostCouponCoverage_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static List<GetCouponCoverageByCouponId_v1Response> getCouponsCoverageByCouponId(Integer couponId) {
        String SQL = "select id, coupon_id couponId, column_name columnName, column_type columnType, relational_operator relationalOperator, column_value columnValue from coupon.coupon_coverage WHERE coupon_coverage.coupon_id = " + couponId;
        List<GetCouponCoverageByCouponId_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(GetCouponCoverageByCouponId_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        List<PostCouponCoverage_v1Response> getCouponsCoverageResult = getCouponsCoverageById(7);
        System.out.println(getCouponsCoverageResult);
    }
}
