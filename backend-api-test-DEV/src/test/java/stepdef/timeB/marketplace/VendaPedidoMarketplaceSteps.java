package stepdef.timeB.marketplace;

import enums.phw31tst.Venda;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import model.timeB.phw31tst.request.PostVendaRequestV1;
import model.timeB.phw31tst.response.PostVendaResponseV1;
import queries.timeB.marketplaceSeller.OrderQuerie;
import service.avengers.pedido.Pedidov2;
import service.timeB.phw31tst.Phw31tst;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigInteger;
import java.util.Map;

public class VendaPedidoMarketplaceSteps {

    @Dado("que efetuo MarketplaceSeller - v1 - Import de pedidos: {string}")
    public void que_efetuo_marketplace_seller_v1_import_de_pedidos(String fluxo, DataTable dataTable) throws Throwable {
        Map<String, String> stringMapFluxo = Map.of("fluxo", fluxo);
        ImportPedidosSteps importPedidosSteps = new ImportPedidosSteps();
        importPedidosSteps.possuo_dados_para_marketplace_seller_v1_import_de_pedidos(stringMapFluxo);
        importPedidosSteps.executo_marketplace_seller_v1_import_de_pedidos();
        importPedidosSteps.sistema_processa_pedido_v2_get_pedido_import_marketplace(dataTable);
    }

    @Quando("efetuo Phw31tst - v1 - Venda")
    public void efetuo_phw31tst_v1_venda() {
        String pedido = Cache.chamadas.get(Util.rota.apply(Pedidov2.GET_PEDIDO)).getServiceSpecs().path.get("pedido");
        OrderQuerie.updateOrderToPrinted(pedido);
        PostVendaRequestV1 vendaRequestV1 = Venda.VENDA_SIMPLES.pojo(BigInteger.valueOf(Long.parseLong(pedido)));
        BuilderRequest.body.accept(Util.rota.apply(Phw31tst.POST_VENDA), vendaRequestV1);
        Phw31tst.postVenda.run();
        PostVendaResponseV1 postVendaResponseV1 = Cache.chamadas.get(Util.rota.apply(Phw31tst.POST_VENDA)).getServiceResponse().getObjectBody(PostVendaResponseV1.class);
        BuilderRequest.path.accept(Util.rota.apply(Phw31tst.PATCH_VENDA), Map.of("code", postVendaResponseV1.getDocumentoSaida().toString()));
        Phw31tst.patchVenda.run();
        System.out.println("Documento de saida: " + postVendaResponseV1.getDocumentoSaida());
    }

    @Quando("sistema processa Phw31tst - v1 - Venda:")
    public void sistema_processa_phw31tst_v1_venda(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Phw31tst.POST_VENDA)).getServiceResponse()
                , PostVendaResponseV1.class
        );
    }
}