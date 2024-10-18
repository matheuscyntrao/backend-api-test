package stepdef.domino.order;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.domino.OrderGenerate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import service.domino.order.OrderV1;
import utils.Util;
import utils.service.BuilderRequest;

public class PostEcommerceOrdersSteps {
    static final String ROTA = OrderV1.POST_ECOMMERCE_ORDERS;

    @Dado("possuo dados para Order - v1 - PostEcommerceOrders {string}")
    public void possuo_dados_para_order_v1_post_ecommerce_orders(String string) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), OrderGenerate.valueOf(string).pojo());
    }

    @Quando("executo Order - v1 - PostEcommerceOrders")
    public void executo_order_v1_post_ecommerce_orders() {
        OrderV1.postEcommerceOrders.run();
    }

    @Entao("sistema processa Order - v1 - PostEcommerceOrders:")
    public void sistema_processa_order_v1_post_ecommerce_orders(DataTable dataTable) {

    }
}
