package stepdef.coupon;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.coupon.response.PostCouponData_v1Response;
import org.testng.Assert;
import queries.coupon.CouponQueries;
import service.coupon.CouponV1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class GetCouponById_v1Steps {

    @Dado("possuo dados para CouponService - v1 - GetCouponById:")
    public void possuoDadosParaCouponServiceV1GetIdForFindById(Map<String, String> arg1) {
        BuilderRequest.path.accept(Util.rota.apply(CouponV1.GET_COUPON_BY_ID), arg1);
    }

    @Quando("executo CouponService - v1 - GetCouponById")
    public void executoCouponServiceV1GetCouponById() {
        CouponV1.getCouponById.run();
    }

    @Entao("sistema processa CouponService - v1 - GetCouponById:")
    public void sistemaProcessaCouponServiceV1GetCouponById(DataTable arg1) throws Throwable{
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(CouponV1.GET_COUPON_BY_ID)).getServiceResponse()
                , PostCouponData_v1Response.class
        );
    }

    @E("valido CouponService - v1 - GetCouponById {string}")
    public void validoCouponServiceV1PostCouponCoverages(String mensagemPrevista) {
        int statusCode = Cache.chamadas.get(Util.rota.apply(CouponV1.GET_COUPON_BY_ID)).getServiceResponse().getStatusCode();
        assumingThat( statusCode == 200, () -> {
            PostCouponData_v1Response response = Cache.chamadas.get(Util.rota.apply(CouponV1.GET_COUPON_BY_ID)).getServiceResponse().getObjectBody(PostCouponData_v1Response.class);
            List<PostCouponData_v1Response> esperado = CouponQueries.getCouponDataById(response.getId());
            Assert.assertEquals(response, esperado.get(0));
        });
        assumingThat(statusCode  == 404, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponV1.GET_COUPON_BY_ID)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
        assumingThat(statusCode  == 400, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(CouponV1.GET_COUPON_BY_ID)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
    }

}
