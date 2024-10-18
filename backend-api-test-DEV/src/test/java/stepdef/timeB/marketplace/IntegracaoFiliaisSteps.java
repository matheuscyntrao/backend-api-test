package stepdef.timeB.marketplace;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.domino.filial.response.GetFilialIdResponse_v1;
import model.timeB.skyhub.response.Subsidiary;
import service.domino.filial.Filialv1;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import service.timeB.skyhub.Skyhub;
import stepdef.domino.filial.GetFiliaisFilial_v1Steps;
import stepdef.timeB.skyhub.GetSkyhubFilaisCode_Steps;
import stepdef.timeB.skyhub.PutSkyhubFiliais_Steps;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegracaoFiliaisSteps {


    @Entao("valido MarketplaceSeller - v1 - Filiais {int}")
    public void valido_marketplace_seller_v1_filiais(Integer filialCode) {
        new GetFiliaisFilial_v1Steps().runGetFilial(filialCode);
        Subsidiary esperado = new Subsidiary().filial2subsidiary(
                Cache.chamadas.get(Util.rota.apply(Filialv1.GET_FILIAIS_FILIAL)).getServiceResponse().getObjectBody(GetFilialIdResponse_v1.class)
        );
        Subsidiary retornado = Cache.chamadas.get(Util.rota.apply(Skyhub.GET_FILIAIS_CODE)).getServiceResponse().getObjectBody(Subsidiary.class);
        assertAll(() -> assertEquals(retornado.getCode(), esperado.getCode()),
                () -> assertEquals(retornado.getName(), esperado.getName()),
                () -> assertEquals(retornado.getOpen_hours(), esperado.getOpen_hours()),
                () -> assertEquals(retornado.getPhone(), esperado.getPhone()),
                () -> assertEquals(retornado.getEmail(), esperado.getEmail()),
                () -> assertEquals(retornado.getLatitude(), esperado.getLatitude()),
                () -> assertEquals(retornado.getLongitude(), esperado.getLongitude()),
                () -> assertEquals(retornado.getMax_delivery_distance(), esperado.getMax_delivery_distance()),
                () -> assertEquals(retornado.getAddress().getStreet(), esperado.getAddress().getStreet()),
                () -> assertEquals(retornado.getAddress().getNumber(), esperado.getAddress().getNumber()),
                () -> assertEquals(retornado.getAddress().getDetail(), esperado.getAddress().getDetail()),
                () -> assertEquals(retornado.getAddress().getNeighborhood(), esperado.getAddress().getNeighborhood()),
                () -> assertEquals(retornado.getAddress().getCity(), esperado.getAddress().getCity()),
                () -> assertEquals(retornado.getAddress().getRegion(), esperado.getAddress().getRegion()),
                () -> assertEquals(retornado.getAddress().getPost_code(), esperado.getAddress().getPost_code()),
                () -> assertEquals(retornado.getAddress().getReference(), esperado.getAddress().getReference()),
                () -> assertEquals(retornado.getSchedules().getMonday(), esperado.getSchedules().getMonday()),
                () -> assertEquals(retornado.getSchedules().getTuesday(), esperado.getSchedules().getTuesday()),
                () -> assertEquals(retornado.getSchedules().getWednesday(), esperado.getSchedules().getWednesday()),
                () -> assertEquals(retornado.getSchedules().getThursday(), esperado.getSchedules().getThursday()),
                () -> assertEquals(retornado.getSchedules().getFriday(), esperado.getSchedules().getFriday()),
                () -> assertEquals(retornado.getSchedules().getSaturday(), esperado.getSchedules().getSaturday()),
                () -> assertEquals(retornado.getSchedules().getSunday(), esperado.getSchedules().getSunday()),
                () -> assertEquals(retornado.getProperties(), esperado.getProperties()));
    }

    @Dado("que efetuo MarketplaceSeller - v1 - PutFiliais:")
    public void que_efetuo_skyhub_v1_put_filiais(Map<String, String> data) throws JsonProcessingException {
        GetSkyhubFilaisCode_Steps getSkyhubFilaisCode_steps = new GetSkyhubFilaisCode_Steps();
        PutSkyhubFiliais_Steps putSkyhubFiliais_steps = new PutSkyhubFiliais_Steps();
        getSkyhubFilaisCode_steps.possuo_dados_para_skyhub_v1_get_filiais_code_path(Map.of("code", data.get("filialCode")));
        getSkyhubFilaisCode_steps.executo_skyhub_v1_get_filiais_code();
        putSkyhubFiliais_steps.possuo_dados_para_skuhub_v1_put_filiais(Map.of("field", data.get("field"), "value", data.get("value")));
        putSkyhubFiliais_steps.possuo_dados_para_skyhub_v1_put_filiais_path(Map.of("code", data.get("filialCode")));
        putSkyhubFiliais_steps.executo_skyhub_v1_put_filiais();
    }

    @Quando("executo MarketplaceSeller - v1 - Filiais")
    public void executo_marketplace_seller_v1_filiais() {
        BuilderRequest.simple.accept(Util.rota.apply(MarketplaceSeller.POST_FILIAIS));
        MarketplaceSeller.postFiliais.run();
        GetSkyhubFilaisCode_Steps getSkyhubFilaisCode_steps = new GetSkyhubFilaisCode_Steps();
        getSkyhubFilaisCode_steps.executo_skyhub_v1_get_filiais_code();
    }
}
