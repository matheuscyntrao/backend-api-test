package service.avengers.pedido;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pedidov1 extends ServiceBase {

    String dominio = "/pedido";
    String url = Util.uri.apply("pedido-service") + dominio;

    String POST_PEDIDOS = "Pedido-v1-PostPedidos";
    String GET_HISTORICO_CLIENTE = "Pedido-v1-GetHistoricoCliente";
    String GET_PEDIDO_DETALHE = "Pedido-v1-GetPedidoDetalhe";
    String GET_PEDIDOS_FINALIZACAO = "Pedido-v1-GetPedidosFinalizacao";
    String GET_PEDIDO_PREVISAO_ENTREGA = "Pedido-v1-GetPedidoPrevisaoEntrega";
    String POST_PEDIDO_CORREIOS = "Pedido-v1-PostPedidoCorreios";
    String GET_PEDIDOS_CPF = "Pedido-v1-GetPedidosCpf";
    String GET_PEDIDOS_CPF_TOTAL_PEDIDOS = "Pedido-v1-GetPedidosCpfTotalPedidos";
    String GET_CLIENTES_ATACADO = "Pedido-v1-GetClientesAtacado";
    String PUT_PEDIDOS_STATUS = "Pedido-v1-PutPedidosStatus";

    Runnable postPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDOS)).getServiceSpecs();
        String endpoint = "/v1/pedidos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDOS));
    };

    Runnable getHistoricoCliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_HISTORICO_CLIENTE)).getServiceSpecs();
        String endpoint = "/v1/historicoCliente/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_HISTORICO_CLIENTE));
    };

    Runnable getPedidoDetalhe = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_DETALHE)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{idPedido}/detalhe";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_DETALHE));
    };

    Runnable getPedidosFinalizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_FINALIZACAO)).getServiceSpecs();
        String endpoint = "/v1/pedidos/finalizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_FINALIZACAO));
    };

    Runnable getPedidoPrevisaoEntrega = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_PREVISAO_ENTREGA)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{pedido}/previsaoentrega";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_PREVISAO_ENTREGA));
    };

    Runnable postPedidoCorreios = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDO_CORREIOS)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{id}/correios";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDO_CORREIOS));
    };

    Runnable getPedidosCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_CPF)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_CPF));
    };

    Runnable getPedidosCpfTotalPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_CPF_TOTAL_PEDIDOS)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{cpf}/totalPedidos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_CPF_TOTAL_PEDIDOS));
    };

    Runnable getClienteAtacado = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ATACADO)).getServiceSpecs();
        String endpoint = "/v1/clientes/atacado/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ATACADO));
    };

    Runnable putPedidosStatus = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PEDIDOS_STATUS)).getServiceSpecs();
        String endpoint = "/v1/pedidos/{id}/status/{status}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PEDIDOS_STATUS));
    };
}
