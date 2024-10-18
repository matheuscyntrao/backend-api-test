package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.PostCouponData_v1Request;
import model.coupon.request.PutCouponData_v1Request;
import model.coupon.response.PostCouponData_v1Response;
import org.testng.Assert;
import queries.coupon.CouponQueries;
import service.coupon.CouponV1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PutCouponData_v1Steps {

    Integer idPostCouponResponse;
    
    @Dado("possuo dados para CouponService - v1 - PostToPutCoupon:")
    public void possuoDadosParaCouponServiceV1PostToPutCoupon(DataTable dataTable) throws JsonProcessingException {
        System.out.println(CucumberUtils.getObjectBody(dataTable, PostCouponData_v1Request.class));
        BuilderRequest.body.accept(Util.rota.apply(CouponV1.POST_COUPON_DATA), CucumberUtils.getObjectBody(dataTable, PostCouponData_v1Request.class));
        CouponV1.postCouponData.run();
        this.idPostCouponResponse = Cache.chamadas.get(Util.rota.apply(CouponV1.POST_COUPON_DATA)).getServiceResponse().getObjectBody(PostCouponData_v1Response.class).getId();
    }

    @E("eu edito CouponService - v1 - PutCouponData:")
    public void euEditoCouponServiceV1PutCouponData(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> arg1 = new HashMap();
        arg1.put("id", idPostCouponResponse.toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponV1.PUT_COUPON_DATA), arg1);
        BuilderRequest.body.accept(Util.rota.apply(CouponV1.PUT_COUPON_DATA), CucumberUtils.getObjectBody(dataTable, PutCouponData_v1Request.class));
    }

    @Quando("executo CouponService - v1 - PutCouponData")
    public void executoCouponServiceV1PutCouponData() {
        CouponV1.putCouponData.run();
    }

    @Entao("sistema processa CouponService - v1 - PutCouponData:")
    public void sistemaProcessaCouponServiceV1PutCouponData(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponV1.PUT_COUPON_DATA)).getServiceResponse()
                , PostCouponData_v1Response.class
        );
    }

    @E("valido CouponService - v1 - PutCouponData {string}")
    public void validoCouponServiceV1PutCouponData(String message) throws Exception {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponV1.PUT_COUPON_DATA)).getServiceResponse().getStatusCode();
        assumingThat(statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponV1.PUT_COUPON_DATA)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(message), "Mensagem esperada:" + message);
        });
        assumingThat(statusCode == 200, () -> {
            PostCouponData_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponV1.PUT_COUPON_DATA)).getServiceResponse().getObjectBody(PostCouponData_v1Response.class);
            List<PostCouponData_v1Response> esperado = CouponQueries.getCouponDataById(response.getId());
            Assert.assertEquals(response,esperado.get(0));
        });
    }


}
