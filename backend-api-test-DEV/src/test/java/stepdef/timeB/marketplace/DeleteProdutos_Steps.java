package stepdef.timeB.marketplace;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.response.ItensDetalheResponseV3;
import model.timeB.skyhub.request.Product_Product;
import model.timeB.skyhub.response.Product;
import queries.timeB.marketplaceSeller.ProductQuerie;
import queries.timeB.marketplaceSeller.ProductsDeleteQuerie;
import service.avengers.mostruario.Mostruariov3;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import service.timeB.skyhub.Skyhub;
import stepdef.avengers.mostruario.BuscarItensDetalhe_v3Steps;
import stepdef.timeB.skyhub.GetSkyhubProdutosCode_Steps;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;
import utils.service.ServiceResponse;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteProdutos_Steps {
    @Dado("que possuo o produto cadastrado - MarketPlaceSeller - v1:")
    public void que_possuo_o_produto_cadastrado_market_place_seller_v1(Map<String, String> dataTable) throws Throwable {
        GetSkyhubProdutosCode_Steps getSkyhubProdutosCode = new GetSkyhubProdutosCode_Steps();
        getSkyhubProdutosCode.possuo_dados_para_skuhub_v1_get_produtos_code_path(dataTable);
        getSkyhubProdutosCode.executo_skyhub_v1_get_produtos_code();
        ServiceResponse response = Cache.chamadas.get(Util.rota.apply(Skyhub.GET_PRODUTOS_CODE)).getServiceResponse();
        if (response.getStatusCode() == 404) {
            BuscarItensDetalhe_v3Steps buscarItensDetalhe_v3Steps = new BuscarItensDetalhe_v3Steps();
            buscarItensDetalhe_v3Steps.efetuo_mostruario_v3_post_itens_detalhe(31, Integer.parseInt(dataTable.get("code")), 2);
            Product esperado = new Product().mostruario2Product(
                    Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class)
                    , ProductQuerie.getProductDetail(Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class).getItens().get(0).getCodigo().toString())
            );
            Product_Product product = Product_Product.builder().product(esperado).build();
            BuilderRequest.body.accept(Util.rota.apply(Skyhub.POST_PRODUTO), product);
            Skyhub.postProdutos.run();
            ServiceResponse responsePost = Cache.chamadas.get(Util.rota.apply(Skyhub.POST_PRODUTO)).getServiceResponse();
            assertAll(() -> assertEquals(201, responsePost.getStatusCode()));
        }
    }

    @Dado("que possuo dados para MarketPlaceSeller - v1 - DeleteProdutos:")
    public void que_possuo_dados_para_market_place_seller_v1_delete_produtos(Map<String, String> dataTable) {
        ProductsDeleteQuerie.prepareProductToDelete(dataTable.get("code"));
        BuilderRequest.simple.accept(Util.rota.apply(MarketplaceSeller.POST_DELETE_PRODUTOS_SKYHUB));
    }

    @Quando("executo MarketPlaceSeller - v1 - DeleteProdutos")
    public void executo_market_place_seller_v1_delete_produtos() {
        MarketplaceSeller.postDeleteProdutosSkyhub.run();
    }

    @Entao("sistema processa MarketplaceSeller - v1 - DeleteProdutos:")
    public void sistema_processa_marketplace_seller_v1_delete_produtos(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(MarketplaceSeller.POST_DELETE_PRODUTOS_SKYHUB)).getServiceResponse()
                , String.class
        );
    }

    @Dado("valido MarketplaceSeller - v1 - DeleteProdutos:")
    public void valido_marketplace_seller_v1_delete_produtos(Map<String, String> dataTable) {
        GetSkyhubProdutosCode_Steps getSkyhubProdutosCode = new GetSkyhubProdutosCode_Steps();
        getSkyhubProdutosCode.possuo_dados_para_skuhub_v1_get_produtos_code_path(dataTable);
        getSkyhubProdutosCode.executo_skyhub_v1_get_produtos_code();
        String exclusionDate = ProductsDeleteQuerie.getExclusionDate(dataTable.get("code"));
        ServiceResponse responseGetByCode = Cache.chamadas.get(Util.rota.apply(Skyhub.GET_PRODUTOS_CODE)).getServiceResponse();
        if (dataTable.get("statusCode").equals("404")) assertNotNull(exclusionDate);
        else assertNull(exclusionDate);
        assertEquals(dataTable.get("statusCode"), responseGetByCode.getStatusCode().toString());
    }
}