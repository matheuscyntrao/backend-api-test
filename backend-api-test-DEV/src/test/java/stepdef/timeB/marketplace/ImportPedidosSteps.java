package stepdef.timeB.marketplace;


import enums.time_b.skyhub.Order;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import model.timeB.skyhub.request.OrderRequest;
import model.timeB.skyhub.request.OrderSetApproval;
import model.timeB.skyhub.response.GetOrderQueueResponse;
import model.timeB.skyhub.response.GetOrdersResponse;
import queries.timeB.marketplaceSeller.OrderQuerie;
import service.timeB.skyhub.Skyhub;
import stepdef.avengers.pedido.GetPedidoV2Steps;
import utils.CucumberUtils;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigInteger;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ImportPedidosSteps {

    public static GetOrderQueueResponse orders;

    @Dado("que possuo dados para MarketplaceSeller - v1 - Import de pedidos:")
    public void possuo_dados_para_marketplace_seller_v1_import_de_pedidos(Map<String, String> fluxo) {
        OrderRequest order = new OrderRequest();
        order.setOrder(Order.valueOf(fluxo.get("fluxo")).pojo());
        BuilderRequest.body.accept(Util.rota.apply(Skyhub.POST_ORDER), order);
    }

    @Quando("executo MarketplaceSeller - v1 - Import de pedidos")
    public void executo_marketplace_seller_v1_import_de_pedidos() {
        zeraFilaPedidos();
        Skyhub.postOrder.run();
    }

    @Quando("sistema processa Pedido - v2 - GetPedidoImportMarketplace:")
    public void sistema_processa_pedido_v2_get_pedido_import_marketplace(DataTable dataTable) throws Throwable {
        Thread.sleep(20000);
        BigInteger pedido = OrderQuerie.getOrderByMarketplaceCode(getPedido().getOrders().get(0).getCode()).getNumeroDoPedido();
        GetPedidoV2Steps pedidoV2Steps = new GetPedidoV2Steps();
        pedidoV2Steps.possuo_dados_para_Pedido_v2_GetPedido_path(Map.of("pedido", pedido.toString()));
        pedidoV2Steps.executo_Pedido_v2_GetPedido();
        pedidoV2Steps.sistema_processa_Pedido_v2_GetPedido(dataTable);
    }

    @Before("@pedidos-marketplace")
    public static void zeraFilaPedidos() {
        Integer statusCode;
        do {
            BuilderRequest.simple.accept(Util.rota.apply(Skyhub.GET_QUEUES_ORDERS));
            Skyhub.getQueuesOrders.run();
            statusCode = Cache.chamadas.get(Util.rota.apply(Skyhub.GET_QUEUES_ORDERS)).getServiceResponse().getStatusCode();
            assumingThat(statusCode != 204, () -> {
                orders = Cache.chamadas.get(Util.rota.apply(Skyhub.GET_QUEUES_ORDERS)).getServiceResponse().getObjectBody(GetOrderQueueResponse.class);
            });
        } while (!statusCode.equals(204));
    }

    public static GetOrdersResponse getPedido() {
        BuilderRequest.simple.accept(Util.rota.apply(Skyhub.GET_ORDERS));
        Skyhub.getOrders.run();
        return Cache.chamadas.get(Util.rota.apply(Skyhub.GET_ORDERS)).getServiceResponse().getObjectBody(GetOrdersResponse.class);
    }

}