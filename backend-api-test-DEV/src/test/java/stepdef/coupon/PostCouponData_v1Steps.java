package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.PostCouponData_v1Request;
import model.coupon.response.PostCouponData_v1Response;
import org.testng.Assert;
import queries.coupon.CouponQueries;
import service.coupon.CouponV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.List;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCouponData_v1Steps {

    @Dado("possuo dados para CouponService - v1 - PostCouponData:")
    public void possuoDadosParaCouponServiceV1PostCouponData(DataTable dataTable) throws JsonProcessingException {
       BuilderRequest.body.accept(Util.rota.apply(CouponV1.POST_COUPON_DATA), CucumberUtils.getObjectBody(dataTable, PostCouponData_v1Request.class));
    }

    @Quando("executo CouponService - v1 - PostCouponData")
    public void executoCouponServiceV1PostCouponData() {
        CouponV1.postCouponData.run();
    }

    @Entao("sistema processa CouponService - v1 - PostCouponData:")
    public void sistemaProcessaCouponServiceV1PostCouponData(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON_DATA)).getServiceResponse()
                , PostCouponData_v1Response.class
        );
    }

    @E("valido CouponService - v1 - PostCouponData {string}")
    public void validoCouponServiceV1PostCouponData(String message) throws Exception {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON_DATA)).getServiceResponse().getStatusCode();
        assumingThat(statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON_DATA)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(message), "Mensagem esperada:" + message);
        });
        assumingThat(statusCode == 201, () -> {
            PostCouponData_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON_DATA)).getServiceResponse().getObjectBody(PostCouponData_v1Response.class);
            List<PostCouponData_v1Response> esperado = CouponQueries.getCouponDataById(response.getId());
            Assert.assertEquals(response,esperado.get(0));
        });
    }
}
