package stepdef.coupon;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.request.CouponIdPathParameter_v1Request;
import model.coupon.request.PostAndPutCouponProduct_v1Request;
import model.coupon.response.PostCouponProduct_v1Response;
import org.testng.Assert;
import queries.coupon.CouponsProductsQueries;
import service.coupon.CouponProduct_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostCouponProduct_v1Steps {

    @Dado("que possudo dados para Coupon-Service - v1 - GetIdCouponProduct:")
    public void quePossudoDadosParaCouponServiceV1GetIdCouponProduct(DataTable dataTable) throws JsonProcessingException {
        CouponIdPathParameter_v1Request postAndPutCouponsItems_v1Request = CucumberUtils.getObjectBody(dataTable, CouponIdPathParameter_v1Request.class);
        Map<String, String> mapCouponIdParameter = new HashMap<>();
        mapCouponIdParameter.put("couponId", postAndPutCouponsItems_v1Request.getCouponId().toString());
        BuilderRequest.path.accept(Util.rota.apply(CouponProduct_v1.POST_PRODUCT), mapCouponIdParameter);
    }

    @E("possuo dados para CouponService - v1 - PostCouponProduct:")
    public void possuoDadosParaCouponServiceV1PostCouponProduct(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(CouponProduct_v1.POST_PRODUCT), CucumberUtils.getObjectBody(dataTable, PostAndPutCouponProduct_v1Request.class));
    }

    @Quando("executo CouponService - v1 - PostCouponProduct")
    public void executoCouponServiceV1PostCouponProduct() {
        CouponProduct_v1.postProducts.run();
    }


    @Entao("sistema processa CouponService - v1 - PostCouponProduct:")
    public void sistemaProcessaCouponServiceV1PostCouponProduct(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.POST_PRODUCT)).getServiceResponse()
                , PostCouponProduct_v1Response.class
        );
    }

    @E("valido CouponService - v1 - PostCouponProduct {string}")
    public void validoCouponServiceV1PostCouponProduct(String mensagem) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.POST_PRODUCT)).getServiceResponse().getStatusCode();
        assumingThat(statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.POST_PRODUCT)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagem), "Mensagem esperada:" + mensagem);
        });
        assumingThat(statusCode == 201, () -> {
            PostCouponProduct_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.POST_PRODUCT)).getServiceResponse().getObjectBody(PostCouponProduct_v1Response.class);
            List<PostCouponProduct_v1Response> esperado = CouponsProductsQueries.getCouponsItemsById(response.getId());
            Assert.assertEquals(response, esperado.get(0));
        });
        assumingThat(statusCode == 404, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.POST_PRODUCT)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagem), "Mensagem esperada:" + mensagem);
        });
    }


}
