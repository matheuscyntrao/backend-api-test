package stepdef.timeB.marketplace;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Entao;
import model.avengers.pedido.response.PedidosPedidoResponse_v2;
import service.avengers.pedido.Pedidov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AlteracoesPedidoServiceSteps {

    @Entao("^sistema processa Pedido - v2 - GetPedido Marketplace:$")
    public void sistema_processa_Pedido_v2_GetPedido(DataTable arg1) throws Throwable {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDO)).getServiceResponse()
                , PedidosPedidoResponse_v2.class
        );
    }

    @Entao("valido Pedido - v2 - GetPedido Marketplace")
    public void valido_pedido_v2_get_pedido_marketplace(Map<String, String> dataTable) {
        PedidosPedidoResponse_v2 pedidoMarketplace = Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDO)).getServiceResponse().getObjectBody(PedidosPedidoResponse_v2.class);
        assertAll(
                () -> assertEquals(6, pedidoMarketplace.getOrigemPedido(), "Origem do pedido divergente"),
                () -> assertNotNull(pedidoMarketplace.getFormaPagamentoMarketplace(), "Campo forma pagamento marketplace está nulo"),
                () -> assertEquals(59, pedidoMarketplace.getFormaPagamentoMarketplace().get(0).getCodigoFormaPagamento(), "Código forma pagamento divergente"),
                () -> assertEquals(dataTable.get("origemDesconto") == null ? null : Integer.parseInt(dataTable.get("origemDesconto")), pedidoMarketplace.getItens().get(0).getDesconto().getOrigemDesconto()),
                () -> assertNotNull(pedidoMarketplace.getIdHubMarketplace(), "IdHubMarketplace está nulo"),
                () -> assertNotNull(pedidoMarketplace.getIdCanalMarketplace(), "IdCanalMarketplace está nulo"),
                () -> assertNotNull(pedidoMarketplace.getMarketplaceOrderCode(), "IdCanalMarketplace está nulo"));
        if(dataTable.get("fluxo").contains("REGRA_PROGRAMADA")){
            assertEquals(3, pedidoMarketplace.getEntrega().getCodigoFormaEntrega(), "Não gerou entrega programada");
            assertEquals(1, pedidoMarketplace.getEntrega().getCodigoTipoEntrega(), "Não gerou entrega programada");
            assertNull(pedidoMarketplace.getEntrega().getValorTaxa());
        } else if (dataTable.get("fluxo").contains("PAC")){
            assertEquals(1, pedidoMarketplace.getEntrega().getCodigoFormaEntrega(), "Não gerou entrega PAC");
            assertEquals(4, pedidoMarketplace.getEntrega().getCodigoTipoEntrega(), "Não gerou entrega PAC");
            assertNull(pedidoMarketplace.getEntrega().getValorTaxa());
        } else if (dataTable.get("fluxo").contains("SEDEX")) {
            assertEquals(1, pedidoMarketplace.getEntrega().getCodigoFormaEntrega(), "Não gerou entrega Sedex");
            assertEquals(2, pedidoMarketplace.getEntrega().getCodigoTipoEntrega(), "Não gerou entrega Sedex");
            assertNull(pedidoMarketplace.getEntrega().getValorTaxa());
        } else if (dataTable.get("fluxo").contains("DESCONTO")) {
            assertNotNull(pedidoMarketplace.getItens().get(0).getDesconto().getValorDesconto(), "O campo valor desconto está nulo");
            assertEquals("P", pedidoMarketplace.getItens().get(0).getDesconto().getTipoDesconto(), "Tipo de desconto divergente");
            assertNotNull(pedidoMarketplace.getItens().get(0).getDesconto().getPercentualDesconto(), "O campo percentual desconto está nulo");
            assertNotNull(pedidoMarketplace.getItens().get(0).getDesconto().getConvenioAvista().getConvCodigoFilialConvenio(), "O campo código filial convenio está nulo");
            assertNotNull(pedidoMarketplace.getItens().get(0).getDesconto().getConvenioAvista().getConvCodigoConvenio(), "O campo código convenio está nulo");
            assertNull(pedidoMarketplace.getEntrega().getValorTaxa());
        } else if (dataTable.get("fluxo").contains("JUROS")) {
            assertEquals(27, Integer.parseInt(String.valueOf(pedidoMarketplace.getValorTotalPedido())), "Valor total do pedido divergente");
            assertEquals(2, Integer.parseInt(String.valueOf(pedidoMarketplace.getEntrega().getValorTaxa())), "Valor da taxa divergente");
            assertEquals(806180, Integer.parseInt(String.valueOf(pedidoMarketplace.getEntrega().getCodigoTaxa())), "Valor do código da taxa divergente");
            assertEquals(25, Integer.parseInt(String.valueOf(pedidoMarketplace.getItens().get(0).getValorTotal())), "Valor total do item divergente");
            assertEquals("27.0", String.valueOf(pedidoMarketplace.getFormaPagamentoMarketplace().get(0).getValor()), "Valor pedido marketplace divergente");
        }
    }
}
