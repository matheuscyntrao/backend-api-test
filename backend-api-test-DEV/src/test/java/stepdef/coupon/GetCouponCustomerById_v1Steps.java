package stepdef.coupon;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.response.GetCouponCustomerByCouponId_v1Response;
import org.testng.Assert;
import queries.coupon.CouponsCustomerQueries;
import service.coupon.CouponCustomer_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetCouponCustomerById_v1Steps {

    Integer couponId;

    @Dado("possuo dados para CouponService - v1 - GetCouponCustomerByCouponId:")
    public void possuoDadosParaCouponServiceVGetCouponCustomerByCouponId(Map<String, String> dataTable) {
        BuilderRequest.path.accept(Util.rota.apply(CouponCustomer_v1.GET_CUSTOMER_BY_COUPON_ID), dataTable);
        couponId = Integer.parseInt(dataTable.get("couponId"));
    }

    @Quando("executo CouponService - v1 - GetCouponCustomerByCouponId")
    public void executoCouponServiceVGetCouponCustomerByCouponId() {
        CouponCustomer_v1.getCustomersByCouponId.run();
    }

    @Entao("sistema processa CouponService - v1 - GetCouponCustomerByCouponId:")
    public void sistemaProcessaCouponServiceVGetCouponCustomerByCouponId(DataTable arg1) throws Throwable{
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.GET_CUSTOMER_BY_COUPON_ID)).getServiceResponse()
                , GetCouponCustomerByCouponId_v1Response[].class
        );
    }

    @E("valido CouponService - v1 - GetCouponCustomerByCouponId {string}")
    public void validoCouponServiceVGetCouponCustomerByCouponId(String mensagemPrevista) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.GET_CUSTOMER_BY_COUPON_ID)).getServiceResponse().getStatusCode();
        assumingThat( statusCode == 200, () -> {
            List<GetCouponCustomerByCouponId_v1Response> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.GET_CUSTOMER_BY_COUPON_ID)).getServiceResponse().getObjectBody(GetCouponCustomerByCouponId_v1Response[].class).clone());
            List<GetCouponCustomerByCouponId_v1Response> esperado = CouponsCustomerQueries.getCouponsCustomerByCouponId(couponId);
            Assert.assertEquals(response, esperado);
        });
        assumingThat( statusCode == 204, () -> {
            Assert.assertTrue(mensagemPrevista.length() == 0);
        });
        assumingThat(statusCode  == 404 || statusCode == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponCustomer_v1.GET_CUSTOMER_BY_COUPON_ID)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
    }

}
