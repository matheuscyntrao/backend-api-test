package stepdef.timeB.marketplace;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Entao;
import model.avengers.filialVirtual.response.PedidoFilialResponse_v1;
import service.avengers.filialVirtual.FilialVirtualv1;
import utils.ResponseValidator;
import utils.Util;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AlteracoesFilialVirtualServiceSteps {

    @Entao("sistema processa FilialVirtual - v1 - GetPedidoFilial Marketplace:")
    public void sistema_processa_filial_virtual_v1_get_pedido_filial_marketplace(DataTable arg1) throws Exception {
        ResponseValidator.validaResponse(arg1
                , Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_PEDIDO_FILIAL)).getServiceResponse()
                , PedidoFilialResponse_v1.class
        );
    }

    @Entao("valido FilialVirtual - v1 - GetPedidoFilial Marketplace")
    public void valido_filial_virtual_v1_get_pedido_filial_marketplace(Map<String,String> dataTable) {
        PedidoFilialResponse_v1 pedidoMarketplace = Cache.chamadas.get(Util.rota.apply(FilialVirtualv1.GET_PEDIDO_FILIAL)).getServiceResponse().getObjectBody(PedidoFilialResponse_v1.class);
        assertAll(
                () -> assertEquals(6, pedidoMarketplace.getOrigemPedido()),
                () -> assertNotNull(pedidoMarketplace.getFormaPagamentoMarketplace()),
                () -> assertEquals(59, pedidoMarketplace.getFormaPagamentoMarketplace().get(0).getCodigoFormaPagamento()),
                () -> assertEquals(dataTable.get("origemDesconto") == null ? null : Integer.parseInt(dataTable.get("origemDesconto")), pedidoMarketplace.getItens()[0].getDesconto().getOrigemDesconto()),
                () -> assertNotNull(pedidoMarketplace.getIdHubMarketplace()),
                () -> assertNotNull(pedidoMarketplace.getIdCanalMarketplace()),
                () -> assertNotNull(pedidoMarketplace.getMarketplaceOrderCode()));
    }
}