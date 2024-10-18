package service.digital.pedidoEcommerce;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface PedidoEcommercev1 extends ServiceBase {

    String dominio = "/pedidoecommerce";
    String url = Util.uri.apply("pedido-ecommerce-service") + dominio;

    String GET_CARRINHO_NUMEROCARRINHO_PEDIDOS = "PedidoEcommerce-v1-GetCarrinhoNumerocarrinhoPedidos";
    String POST_PEDIDO = "PedidoEcommerce-v1-PostPedido";
    String POST_PEDIDO_CARRINHO = "PedidoEcommerce-v1-PostPedidoCarrinho";
    String GET_PEDIDO_CARRINHO_NUMEROCARRINHO = "PedidoEcommerce-v1-GetPedidoCarrinhoNumerocarrinho";
    String PATCH_PEDIDO_NUMEROPEDIDO_PANVELPAY = "PedidoEcommerce-v1-PatchPedidoNumeropedidoPanvelpay";
    String GET_PEDIDOS_IDENTIFICADORCLIENTE_HISTORICO = "PedidoEcommerce-v1-GetPedidosIdentificadorclienteHistorico";
    String GET_PEDIDOS_NUMEROPEDIDO_HISTORICO_STATUS = "PedidoEcommerce-v1-GetPedidosNumeropedidoHistoricoStatus";
    String GET_PEDIDOS_ORDERID = "PedidoEcommerce-v1-GetPedidosOrderid";

    Runnable getCarrinhoNumerocarrinhoPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CARRINHO_NUMEROCARRINHO_PEDIDOS)).getServiceSpecs();
        String endpoint = "/v1/carrinho/{numeroCarrinho}/pedidos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CARRINHO_NUMEROCARRINHO_PEDIDOS));
    };

    Runnable postPedido = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDO)).getServiceSpecs();
        String endpoint = "/v1/pedido";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDO));
    };

    Runnable postPedidoCarrinho = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDO_CARRINHO)).getServiceSpecs();
        String endpoint = "/v1/pedido/carrinho";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDO_CARRINHO));
    };

    Runnable getPedidoCarrinhoNumerocarrinho = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_CARRINHO_NUMEROCARRINHO)).getServiceSpecs();
        String endpoint = "/v1/pedido/carrinho/{numeroCarrinho}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_CARRINHO_NUMEROCARRINHO));
    };

    Runnable patchPedidoNumeropedidoPanvelpay = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_PEDIDO_NUMEROPEDIDO_PANVELPAY)).getServiceSpecs();
        String endpoint = "/v1/pedido/{numeroPedido}/panvelpay";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_PEDIDO_NUMEROPEDIDO_PANVELPAY));
    };

    Runnable getPedidosIdentificadorclienteHistorico = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_IDENTIFICADORCLIENTE_HISTORICO)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{identificadorCliente}/historico";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_IDENTIFICADORCLIENTE_HISTORICO));
    };

    Runnable getPedidosNumeropedidoHistoricoStatus = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_NUMEROPEDIDO_HISTORICO_STATUS)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{numeroPedido}/historico/status";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_NUMEROPEDIDO_HISTORICO_STATUS));
    };

    Runnable getPedidosOrderid = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_ORDERID)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{orderId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_ORDERID));
    };
}
