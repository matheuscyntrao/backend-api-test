package queries.coupon;

import com.epam.reportportal.service.ReportPortal;
import model.coupon.response.PostCouponData_v1Response;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import utils.database.PostGresBaseQueries;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

public class CouponQueries extends PostGresBaseQueries {

    public static List<PostCouponData_v1Response> getCouponDataById(Integer id) {
        String SQL = "select id, description, detailed_description detailedDescription, " +
                "id_campaign idCampaign, public pub, cuponable, limit_uses limitUses, " +
                "individual_uses individualUses, start_date startDate, end_date endDate, " +
                "duration_days durationDays, promocode, dynamic_promocode dynamicPromocode, " +
                "discount_type discountType, bonus_value bonusValue, minimum_value minimumValue, " +
                "discount_percentage discountPercentage, price, rebate_percentage rebatePercentage, " +
                "rebate_value rebateValue, date_trunc('second', creation_date::timestamp) creationDate, " +
                "date_trunc('second', alteration_date::timestamp) alterationDate, " +
                "active from coupon.coupon_data WHERE id = " + id;
        List<PostCouponData_v1Response> result = getTemplate().query(SQL, new BeanPropertyRowMapper<>(PostCouponData_v1Response.class));
        ReportPortal.emitLog(result.toString(), "INFO", Date.from(Instant.now()));
        return result;
    }

    public static void main(String[] args) {
        PostCouponData_v1Response getCouponsResult = new PostCouponData_v1Response();
    }
}
