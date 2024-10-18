package stepdef.domino.order;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.crossover.cliente.Clientev2;
import service.domino.order.OrderV1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.Cache;

import java.util.Map;

public class PostOrderEcommerceOrdersSteps {

    @Dado("possuo dados para Post Order - v1 - EcommerceOrders generate:")
    public void possuo_dados_para_post_order_v1_ecommerce_orders_generate(Map<String, String> dataTable) {
        Long codigoEntidadeComercial = Long.parseLong(Cache.chamadas.get(Util.rota.apply(Clientev2.POST_CLIENTES)).getServiceResponse().getObjectBody(String.class));

    }

    @Quando("executo Post Order - v1 - EcommerceOrders")
    public void executo_post_order_v1_ecommerce_orders() {
        OrderV1.postEcommerceOrders.run();
    }

    @Entao("sistema processa Post Order - v1 - EcommerceOrders:")
    public void sistema_processa_post_order_v1_ecommerce_orders(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(OrderV1.POST_ECOMMERCE_ORDERS)).getServiceResponse()
                , String.class
        );
    }
}
