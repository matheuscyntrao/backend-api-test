package stepdef.coupon;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.response.GetCouponProductByCouponId_v1Response;
import org.testng.Assert;
import queries.coupon.CouponsProductsQueries;
import service.coupon.CouponProduct_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetCouponProductById_v1Steps {

    Integer couponId;

    @Dado("possuo dados para CouponService - v1 - GetCouponProductByCouponId:")
    public void possuoDadosParaCouponServiceV1GetCouponProductByCouponId(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(CouponProduct_v1.GET_PRODUCT_BY_COUPON_ID), dataTable);
        couponId = Integer.parseInt(dataTable.get("couponId"));
    }

    @Quando("executo CouponService - v1 - GetCouponProductByCouponId")
    public void executoCouponServiceV1GetCouponProductByCouponId() {
        CouponProduct_v1.getProductsByCouponId.run();
    }

    @Entao("sistema processa CouponService - v1 - GetCouponProductByCouponId:")
    public void sistemaProcessaCouponServiceV1GetCouponProductByCouponId(DataTable arg1) throws Throwable{
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.GET_PRODUCT_BY_COUPON_ID)).getServiceResponse()
                , GetCouponProductByCouponId_v1Response[].class
        );
    }

    @E("valido CouponService - v1 - GetCouponProductByCouponId {string}")
    public void validoCouponServiceV1GetCouponProductByCouponId(String mensagemPrevista) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.GET_PRODUCT_BY_COUPON_ID)).getServiceResponse().getStatusCode();
        assumingThat( statusCode == 200, () -> {
            List<GetCouponProductByCouponId_v1Response> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.GET_PRODUCT_BY_COUPON_ID)).getServiceResponse().getObjectBody(GetCouponProductByCouponId_v1Response[].class).clone());
            List<GetCouponProductByCouponId_v1Response> esperado = CouponsProductsQueries.getCouponsItemsByCouponId(couponId);
            Assert.assertEquals(response, esperado);
        });
        assumingThat( statusCode == 204, () -> Assert.assertEquals(mensagemPrevista.length(), 0));
        assumingThat(statusCode  == 404 || statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponProduct_v1.GET_PRODUCT_BY_COUPON_ID)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
    }

}
