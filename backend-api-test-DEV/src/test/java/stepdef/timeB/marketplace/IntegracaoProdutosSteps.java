package stepdef.timeB.marketplace;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.mostruario.response.ItensDetalheResponseV3;
import model.timeB.skyhub.response.Product;
import org.apache.commons.lang.WordUtils;
import queries.timeB.marketplaceSeller.ProductQuerie;
import service.avengers.mostruario.Mostruariov3;
import service.timeB.marketplaceSeller.MarketplaceSeller;
import service.timeB.skyhub.Skyhub;
import stepdef.avengers.mostruario.BuscarItensDetalhe_v3Steps;
import stepdef.timeB.skyhub.GetSkyhubProdutosCode_Steps;
import stepdef.timeB.skyhub.PutSkyhubProdutos_Steps;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class IntegracaoProdutosSteps {
    @Quando("executo MarketPlaceSeller - v1 - LimpaTabelaBKP")
    public void executo_market_place_seller_v1_limpa_tabela_bkp() {
        assumingThat(ProductQuerie.countProductRows() > 10000, () -> {
            ProductQuerie.deleteProductBkpRows();
        });
    }

    @Entao("executo MarketPlaceSeller - v1 - PopulaTabelaBKP")
    public void executo_market_place_seller_v1_popula_tabela_bkp() {
        ProductQuerie.productsOriginalToBkp();
    }

    @Entao("executo MarketplaceSeller - v1 - RollbackProdutos")
    public void executo_marketplace_seller_v1_rollback_produtos() {
        assumingThat(ProductQuerie.countProductBkpRows() > 10000, () -> {
            ProductQuerie.deleteProductRows();
            ProductQuerie.productsBkpToOriginal();
        });
    }

    @Dado("que possuo dados para MarketplaceSeller - v1 - IntegracaoProdutos")
    public void que_possuo_dados_para_marketplace_seller_v1_integracao_produtos(Map<String, String> dataTable) throws Throwable {
        assumingThat(ProductQuerie.countProductBkpRows() > 10000, () -> {
            ProductQuerie.deleteProduct(dataTable.get("code"));
        });
        ProductQuerie.insertOneProduct(dataTable.get("code"));
        DeleteProdutos_Steps deleteProdutos_steps = new DeleteProdutos_Steps();
        deleteProdutos_steps.que_possuo_dados_para_market_place_seller_v1_delete_produtos(dataTable);
        deleteProdutos_steps.executo_market_place_seller_v1_delete_produtos();
        deleteProdutos_steps.que_possuo_o_produto_cadastrado_market_place_seller_v1(dataTable);
    }

    @Quando("que efetuo MarketplaceSeller - v1 - PutProdutos:")
    public void que_efetuo_marketplace_seller_v1_put_produtos(Map<String, String> dataTable) throws Throwable {
        BuscarItensDetalhe_v3Steps buscarItensDetalhe_v3Steps = new BuscarItensDetalhe_v3Steps();
        buscarItensDetalhe_v3Steps.efetuo_mostruario_v3_post_itens_detalhe(31, Integer.parseInt(dataTable.get("produtoCode")), Integer.parseInt(dataTable.get("perfil")));
        GetSkyhubProdutosCode_Steps getSkyhubProdutosCode_steps = new GetSkyhubProdutosCode_Steps();
        getSkyhubProdutosCode_steps.possuo_dados_para_skuhub_v1_get_produtos_code_path(Map.of("code", dataTable.get("produtoCode")));
        getSkyhubProdutosCode_steps.executo_skyhub_v1_get_produtos_code();
        PutSkyhubProdutos_Steps putSkyhubProdutos_steps = new PutSkyhubProdutos_Steps();
        putSkyhubProdutos_steps.possuo_dados_para_skyhub_v1_put_produtos_path(Map.of("code", dataTable.get("produtoCode")));
        putSkyhubProdutos_steps.possuo_dados_para_skuhub_v1_put_produtos(Map.of("field", dataTable.get("field"), "value", dataTable.get("value")));
        putSkyhubProdutos_steps.executo_skyhub_v1_put_produtos();
    }

    @Quando("executo MarketplaceSeller - v1 - Produtos")
    public void executo_marketplace_seller_v1_produtos() {
        BuilderRequest.simple.accept(Util.rota.apply(MarketplaceSeller.POST_PRODUTOS));
        MarketplaceSeller.postProdutos.run();
    }

    @E("valido MarketplaceSeller - v1 - Produtos")
    public void valido_marketplace_seller_v1_produtos(Map<String, String> dataTable) throws Throwable {
        BuscarItensDetalhe_v3Steps buscarItensDetalhe_v3Steps = new BuscarItensDetalhe_v3Steps();
        buscarItensDetalhe_v3Steps.efetuo_mostruario_v3_post_itens_detalhe(31, Integer.parseInt(dataTable.get("code")), 2);
        Product esperado = new Product().mostruario2Product(
                Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class)
                , ProductQuerie.getProductDetail(Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class).getItens().get(0).getCodigo().toString())
        );
        buscarItensDetalhe_v3Steps.efetuo_mostruario_v3_post_itens_detalhe(31, Integer.parseInt(dataTable.get("code")), 1);
        Product esperadoPerfil1 = new Product().mostruario2Product(
                Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class)
                , ProductQuerie.getProductDetail(Cache.chamadas.get(Util.rota.apply(Mostruariov3.POST_DETALHE)).getServiceResponse().getObjectBody(ItensDetalheResponseV3.class).getItens().get(0).getCodigo().toString())
        );
        Product retornado = Cache.chamadas.get(Util.rota.apply(Skyhub.GET_PRODUTOS_CODE)).getServiceResponse().getObjectBody(Product.class);
        assertAll(
                () -> assertEquals(retornado.getSku(), esperado.getSku()),
                () -> assertEquals(retornado.getName().toUpperCase(), esperado.getName()),
                () -> assertEquals(retornado.getDescription(), esperado.getDescription()),
                () -> assertEquals(retornado.getStatus(), esperado.getStatus()),
                () -> assertEquals(retornado.getQty(), esperado.getQty()),
                () -> assertEquals(retornado.getPrice(), esperado.getPrice()),
                () -> assertEquals(retornado.getPromotionalPrice(), esperado.getPromotionalPrice()),
                () -> assertEquals(retornado.getCost(), esperado.getCost()),
                () -> assertEquals(retornado.getWeight(), esperado.getWeight()),
                () -> assertEquals(retornado.getHeight(), esperado.getHeight()),
                () -> assertEquals(retornado.getWidth(), esperado.getWidth()),
                () -> assertEquals(retornado.getLength(), esperado.getLength()),
                () -> assertEquals(retornado.getBrand(), esperado.getBrand()),
                () -> assertEquals(retornado.getEan(), esperado.getEan()),
                () -> assertEquals(retornado.getNbm(), esperado.getNbm()),
                () -> assertEquals(retornado.getCategories(), esperado.getCategories()),
                () -> assertEquals(retornado.getSpecifications(), esperado.getSpecifications()),
                () -> assertNotEquals(esperadoPerfil1.getPromotionalPrice(), retornado.getPromotionalPrice())
        );
    }
}