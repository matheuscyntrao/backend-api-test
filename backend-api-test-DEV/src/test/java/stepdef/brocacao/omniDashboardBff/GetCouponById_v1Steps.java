package stepdef.brocacao.omniDashboardBff;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.brocacao.omniDashboardBff.GetCouponById_V1Response;
import service.brocacao.omniDashboardBff.Couponv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;


public class GetCouponById_v1Steps {

    @Dado("possuo dados para OmniDashBoardBff - v1 - GetCouponById:")
    public void possuoDadosParaOmniDashBoardBffV1PostCouponGetIdForFindById(Map<String, String> arg1) {
        BuilderRequest.path.accept(Util.rota.apply(Couponv1.GET_COUPON_BY_ID), arg1);
    }

    @Quando("executo OmniDashBoardBff - v1 - GetCouponById")
    public void executoOmniDashBoardBffV1GetCouponById() {
        Couponv1.getCouponById.run();
    }

    @Entao("sistema processa OmniDashBoardBff - v1 - GetCouponById:")
    public void sistemaProcessaOmniDashBoardBffV1GetCouponById(DataTable arg1) throws Throwable{
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Couponv1.GET_COUPON_BY_ID)).getServiceResponse()
                , GetCouponById_V1Response.class
        );
    }

}
