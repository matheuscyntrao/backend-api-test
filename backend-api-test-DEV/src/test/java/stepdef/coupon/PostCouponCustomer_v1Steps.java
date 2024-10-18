package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.CouponIdPathParameter_v1Request;
import model.coupon.request.PostAndPutCouponCustomer_v1Request;
import model.coupon.response.PostCouponCustomer_v1Response;
import org.testng.Assert;
import queries.coupon.CouponsCustomerQueries;
import service.coupon.CouponCustomer_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCouponCustomer_v1Steps {

    private Integer idCoupon;

    @Dado("que possudo dados para Coupon-Service - v1 - GetIdCouponCustomer:")
    public void quePossudoDadosParaCouponServiceV1GetIdCouponCoverage(DataTable dataTable) throws JsonProcessingException {
        CouponIdPathParameter_v1Request couponIdPathParameter_v1Request = CucumberUtils.getObjectBody(dataTable, CouponIdPathParameter_v1Request.class);
        Map<String, String> mapCouponIdParameter = new HashMap<>();
        mapCouponIdParameter.put("couponId", couponIdPathParameter_v1Request.getCouponId().toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER), mapCouponIdParameter);
    }

    @E("possuo dados para CouponService - v1 - PostCouponCustomer:")
    public void possuoDadosParaCouponServiceV1PostCouponCustomer(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER), CucumberUtils.getObjectBody(dataTable, PostAndPutCouponCustomer_v1Request.class));
    }

    @Quando("executo CouponService - v1 - PostCouponCustomer")
    public void executoCouponServiceV1PostCouponCustomer() {
        CouponCustomer_v1.postCustomers.run();
    }


    @Entao("sistema processa CouponService - v1 - PostCouponCustomer:")
    public void sistemaProcessaCouponServiceV1PostCouponCustomer(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER)).getServiceResponse()
                , PostCouponCustomer_v1Response.class
        );
    }

    @E("valido CouponService - v1 - PostCouponCustomer {string}")
    public void validoCouponServiceV1PostCouponCustomer(String mensagem) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER)).getServiceResponse().getStatusCode();
        assumingThat(statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagem), "Mensagem esperada:" + mensagem);
        });
        assumingThat(statusCode == 201, () -> {
            PostCouponCustomer_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.POST_CUSTOMER)).getServiceResponse().getObjectBody(PostCouponCustomer_v1Response.class);
            List<PostCouponCustomer_v1Response> esperado = CouponsCustomerQueries.getCouponsCustomersById(response.getId());
            Assert.assertEquals(response, esperado.get(0));
        });
    }
}
