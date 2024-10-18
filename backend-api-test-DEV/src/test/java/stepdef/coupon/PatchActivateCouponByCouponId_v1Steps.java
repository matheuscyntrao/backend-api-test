package stepdef.coupon;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.entrega.v3.request.PostEntregas;
import org.testng.Assert;
import service.coupon.CouponV1;
import service.digital.entrega.Entrega_v1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PatchActivateCouponByCouponId_v1Steps {

    @Dado("possuo dados para CouponService - v1 - PatchActivateCouponByCouponId:")
    public void possuoDadosParaCouponServiceV1PatchActivateCouponByCouponId(Map<String, String> arg1) {
        BuilderRequest.path.accept(Util.rota.apply(CouponV1.PATCH_ACTIVATE_COUPON_BY_ID), arg1);
    }

    @Quando("executo CouponService - v1 - PatchActivateCouponByCouponId")
    public void executoCouponServiceV1PatchActivateCouponByCouponId() {
        CouponV1.patchActivate.run();
    }

    @Entao("sistema processa CouponService - v1 - PatchActivateCouponByCouponId:")
    public void sistemaProcessaCouponServiceV1PatchActivateCouponByCouponId(DataTable arg1) throws Throwable{
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(CouponV1.PATCH_ACTIVATE_COUPON_BY_ID)).getServiceResponse()
                , String.class
        );
    }

    @E("valido CouponService - v1 - PatchActivateCouponByCouponId {string}")
    public void validoCouponServiceV1PatchActivateCouponByCouponId(String mensagemPrevista) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponV1.PATCH_ACTIVATE_COUPON_BY_ID)).getServiceResponse().getStatusCode();
        assumingThat( statusCode == 204, () -> {
            String response = Cache.chamadas.get(Util.rota.apply(CouponV1.PATCH_ACTIVATE_COUPON_BY_ID)).getServiceResponse().getObjectBody(String.class);
            Assert.assertTrue(response == null);
        });
        assumingThat(statusCode  == 404, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponV1.PATCH_ACTIVATE_COUPON_BY_ID)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
    }

}
