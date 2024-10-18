package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.CouponIdPathParameter_v1Request;
import model.coupon.request.PostAndPutCouponCoverage_v1Request;
import model.coupon.response.PostCouponCoverage_v1Response;
import org.testng.Assert;
import queries.coupon.CouponsCoverageQueries;
import service.coupon.CouponCoverage_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCouponCoverage_v1Steps {

    @Dado("que possudo dados para Coupon-Service - v1 - GetIdCouponCoverage:")
    public void quePossudoDadosParaCouponServiceVGetIdCouponCoverage(DataTable dataTable) throws JsonProcessingException {
        CouponIdPathParameter_v1Request couponIdPathParameter_v1Request = CucumberUtils.getObjectBody(dataTable, CouponIdPathParameter_v1Request.class);
        Map<String, String> mapCouponIdParameter = new HashMap<>();
        mapCouponIdParameter.put("couponId", couponIdPathParameter_v1Request.getCouponId().toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE), mapCouponIdParameter);
    }

    @E("possuo dados para CouponService - v1 - PostCouponCoverage:")
    public void possuoDadosParaCouponServiceV1PostCouponCoverage(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE), CucumberUtils.getObjectBody(dataTable, PostAndPutCouponCoverage_v1Request.class));
    }

    @Quando("executo CouponService - v1 - PostCouponCoverage")
    public void executoCouponServiceV1PostCouponCoverage() {
        CouponCoverage_v1.postCoverage.run();
    }


    @Entao("sistema processa CouponService - v1 - PostCouponCoverage:")
    public void sistemaProcessaCouponServiceV1PostCouponCoverage(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE)).getServiceResponse()
                , PostCouponCoverage_v1Response.class
        );
    }

    @E("valido CouponService - v1 - PostCouponCoverage {string}")
    public void validoCouponServiceV1PostCouponCoverage(String mensagem) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE)).getServiceResponse().getStatusCode();
        assumingThat(statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagem), "Mensagem esperada:" + mensagem);
        });
        assumingThat(statusCode == 201, () -> {
            PostCouponCoverage_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE)).getServiceResponse().getObjectBody(PostCouponCoverage_v1Response.class);
            List<PostCouponCoverage_v1Response> esperado = CouponsCoverageQueries.getCouponsCoverageById(response.getId());
            Assert.assertEquals(response, esperado.get(0));
        });
        assumingThat(statusCode == 404, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponCoverage_v1.POST_COVERAGE)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagem), "Mensagem esperada:" + mensagem);
        });
    }


}
