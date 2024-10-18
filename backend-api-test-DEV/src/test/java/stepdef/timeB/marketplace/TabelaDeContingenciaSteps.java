package stepdef.timeB.marketplace;

import entity.marketplaceSeller.FreightTableEntity;
import io.cucumber.java.pt.Entao;
import model.timeB.marketplaceSeller.response.DeliveriesResponse_v1;
import queries.timeB.marketplaceSeller.FreteQuerie;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import utils.Util;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabelaDeContingenciaSteps {

    @Entao("valido MarketplaceSeller - v1 - Tabela de contingencia")
    public void valido_marketplace_seller_v1_tabela_de_contingencia(Map<String, String> datatable) {
        FreightTableEntity frete = FreteQuerie.getFreightData(datatable.get("destinationZip"), datatable.get("weight"));
        DeliveriesResponse_v1 response_v1 = Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_API_FRETES)).getServiceResponse().getObjectBody(DeliveriesResponse_v1.class);
        Integer total = FreteQuerie.getTotalFaixasCEP() * FreteQuerie.getTotalFaixasPeso();
        assertAll(
                () -> assertEquals(total, FreteQuerie.getTotalFretes()),
                () -> assertEquals(frete.getCustoFrete(), response_v1.getShippingQuotes().get(0).getShippingCost()),
                () -> assertEquals(frete.getPrazoDias(), response_v1.getShippingQuotes().get(0).getDeliveryTime().getTotal())
        );
    }
}
