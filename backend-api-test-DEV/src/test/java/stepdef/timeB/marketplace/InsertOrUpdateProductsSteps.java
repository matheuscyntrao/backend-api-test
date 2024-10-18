package stepdef.timeB.marketplace;

import entity.marketplaceSeller.ProductMarketplaceEntity;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import queries.timeB.marketplaceSeller.ProductQuerie;
import queries.timeB.marketplaceSeller.ProductsToInsertOrUpdateQuerie;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InsertOrUpdateProductsSteps {
    @Dado("possuo dados para {string} na tabela de itens Marketplace - v1")
    public void possuo_dados_para_na_tabela_de_itens_marketplace_v1(String fluxo, Map<String,String> dataTable) {
        ProductsToInsertOrUpdateQuerie.prepareForAutomation(fluxo, dataTable.get("produto"));
    }

    @Quando("executo {string} na tabela de itens Marketplace - v1")
    public void executo_na_tabela_de_itens_marketplace_v1(String fluxo, Map<String,String> dataTable) {
        ProductsToInsertOrUpdateQuerie.executeOperation(dataTable.get("produto"));
    }

    @Entao("valido {string} do produto {string} na tabela de itens Marketplace - v1")
    public void valido_na_tabela_de_itens_marketplace_v1(String fluxo, String produto) {
        ProductMarketplaceEntity product = ProductQuerie.getProductMarketplace(produto);
        assertAll(() -> assertNull(product.getDataExclusao()));
    }
}
