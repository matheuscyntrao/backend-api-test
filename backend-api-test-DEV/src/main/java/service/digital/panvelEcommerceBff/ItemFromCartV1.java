package service.digital.panvelEcommerceBff;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ItemFromCartV1 extends ServiceBase {

    String dominio = "/panvel-ecommerce-bff";
    String url = Util.uri.apply("panvel-ecommerce-bff") + dominio;

    String POST_SAVE_ITENS_LIST_TO_CART = "PanvelEcommerceBff-v1-PostSaveItensListToCart";
    String PATCH_ADICIONAR_OU_ALTERAR_QUANTIDADE = "PanvelEcommerceBff-v1-PatchAdicionarOuAlterarQuantidade";
    String DELETE_ITEM_LIST_TO_CART_BY_PANVELCODE = "PanvelEcommerceBff-v1-DeleteItemListToCartByPanvelCode";

    Runnable postSaveItensListToCart = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_SAVE_ITENS_LIST_TO_CART)).getServiceSpecs();
        String endpoint = "/v1/cart/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_SAVE_ITENS_LIST_TO_CART));
    };

    Runnable patchAdicionarOuAlterarQuantidade = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ADICIONAR_OU_ALTERAR_QUANTIDADE)).getServiceSpecs();
        String endpoint = "/v1/cart/item";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_ADICIONAR_OU_ALTERAR_QUANTIDADE));
    };

    Runnable deleteItemListToCartByPanvelCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_ITEM_LIST_TO_CART_BY_PANVELCODE)).getServiceSpecs();
        String endpoint = "/v1/cart/item/{panvelCode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_ITEM_LIST_TO_CART_BY_PANVELCODE));
    };

}
