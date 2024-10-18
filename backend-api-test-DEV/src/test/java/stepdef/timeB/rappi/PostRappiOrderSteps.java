package stepdef.timeB.rappi;

import entity.avangers.pedido.AloFormasPagamentosPedidosEntity;
import entity.avangers.pedido.AloItensDosPedidosEntity;
import entity.avangers.pedido.AloPedidosMarketplaceEntity;
import enums.time_b.rappi.Order;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.pedido.response.PedidosPedidoResponse_v2;
import model.timeB.rappi.request.PostOrderRequestV1;
import model.timeB.rappi.response.PostOrderResponseV1Success;
import queries.avengers.pedidos.PedidosMarketplaceQuerie;
import service.avengers.pedido.Pedidov2;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import stepdef.avengers.pedido.GetPedidoV2Steps;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigInteger;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PostRappiOrderSteps {
    @Dado("que possuo dados para MarketplaceSeller - v1 - PostRappiOrder:")
    public void que_possuo_dados_para_marketplace_seller_v1_post_rappi_order(Map<String, String> dataTable) {
        PostOrderRequestV1 orderRequestV1 = Order.valueOf(dataTable.get("fluxo")).pojo();
        BuilderRequest.body.accept(Util.rota.apply(MarketplaceSeller.POST_RAPPI_ORDER), orderRequestV1);
    }

    @Quando("executo MarketplaceSeller - v1 - PostRappiOrder")
    public void executo_marketplace_seller_v1_post_rappi_order() {
        MarketplaceSeller.postRappiOrder.run();
    }

    @Quando("sistema processa MarketplaceSeller - v1 - PostRappiOrder:")
    public void sistema_processa_marketplace_seller_v1_post_rappi_order(DataTable dataTable) throws Throwable {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_RAPPI_ORDER)).getServiceResponse()
                , PostOrderResponseV1Success.class
        );
    }

    @Entao("valido Pedido - v2 - GetPedido Marketplace Rappi")
    public void valido_pedido_v2_get_pedido_marketplace(Map<String, String> dataTable) throws Throwable {
        PostOrderResponseV1Success pedido = Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_RAPPI_ORDER)).getServiceResponse().getObjectBody(PostOrderResponseV1Success.class);
        GetPedidoV2Steps pedidoV2Steps = new GetPedidoV2Steps();
        pedidoV2Steps.possuo_dados_para_Pedido_v2_GetPedido_path(Map.of("pedido", pedido.getRetailOrderId()));
        pedidoV2Steps.executo_Pedido_v2_GetPedido();
        PedidosPedidoResponse_v2 pedidoMarketplace = Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDO)).getServiceResponse().getObjectBody(PedidosPedidoResponse_v2.class);
        AloPedidosMarketplaceEntity aloPedidos = PedidosMarketplaceQuerie.getAloPedidosMarketplace(pedido.getRetailOrderId());
        AloItensDosPedidosEntity aloItensDosPedidos = PedidosMarketplaceQuerie.getAloItensDosPedidos(pedido.getRetailOrderId());
        AloFormasPagamentosPedidosEntity aloFormasPagamentosPedidos = PedidosMarketplaceQuerie.getAloFormasPagementosPedidos(pedido.getRetailOrderId());

        assertAll(
                () -> assertEquals(6, pedidoMarketplace.getOrigemPedido()),
                () -> assertEquals("I", pedidoMarketplace.getTipoPedido()),
                () -> assertEquals("S", pedidoMarketplace.getImprimeDocumentoCupom()),
                () -> assertEquals("N", pedidoMarketplace.getPedidoUrgente()),
                () -> assertNotNull(pedidoMarketplace.getFormaPagamentoConvenio()),
                () -> assertEquals(BigInteger.valueOf(36), pedidoMarketplace.getFormaPagamentoConvenio().getCodigoFormaPagamento()),
                () -> assertEquals(dataTable.get("origemDesconto") == null ? null : Integer.parseInt(dataTable.get("origemDesconto")), pedidoMarketplace.getItens().get(0).getDesconto().getOrigemDesconto()),
                () -> assertEquals(2,pedidoMarketplace.getIdHubMarketplace()),
                () -> assertEquals(3,pedidoMarketplace.getIdCanalMarketplace()),
                () -> assertNotNull(pedidoMarketplace.getMarketplaceOrderCode()),
                () -> assertEquals(aloPedidos.getObservacao(), pedidoMarketplace.getObservacao()),
                () -> assertNotNull(aloItensDosPedidos.getCodigoDoItem()),
                () -> assertNotNull(aloItensDosPedidos.getNumeroDoItem()),
                () -> assertNotNull(aloItensDosPedidos.getQuantidade()),
                () -> assertNotNull(aloItensDosPedidos.getValorTotalDoItem()),
                () -> assertNotNull(aloItensDosPedidos.getValorUnitario()),
                () -> assertNotNull(aloFormasPagamentosPedidos.getCodigoDaFilialDoConvenio()),
                () -> assertNotNull(aloFormasPagamentosPedidos.getCodigoDaFormaDePagamento()),
                () -> assertNotNull(aloFormasPagamentosPedidos.getCodigoDoConvenio()),
                () -> assertNotNull(aloFormasPagamentosPedidos.getSequenciaFormaPagtoPedido()));
    }
}