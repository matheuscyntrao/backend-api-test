package service.avengers.pedido;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pedidov2 extends ServiceBase {

    String dominio = "/pedido";
    String url = Util.uri.apply("pedido-service") + dominio;

    String POST_PEDIDOS = "Pedido-v2-PostPedidos";
    String GET_PEDIDO = "Pedido-v2-GetPedido";
    String GET_PEDIDOS_FILIAL = "Pedido-v2-GetPedidosFilial";
    String GET_PEDIDO_HISTORICO_STATUS = "Pedido-v2-GetPedidoHistoricoStatus";
    String POST_PEDIDOS_AVALIACAO = "Pedido-v2-PostPedidosAvaliacao";
    String GET_PEDIDO_AVALIACAO = "Pedido-v2-GetPedidoAvaliacao";
    String POST_PEDIDOS_MOVE = "Pedido-v2-PostPedidosMove";

    String GET_PEDIDOS_RETIRADAS = "Pedido-v2-GetRetiradas";
    String POST_PEDIDOS_RETIRADAS = "Pedido-v2-PostRetiradas";

    String GET_PEDIDO_GEOCOORDENADA = "Pedido-v2-GetPedidoGeoCoordenada";
    String GET_PEDIDO_PREVISAO_ENTREGA = "Pedido-v2-GetPedidoPrevisaoEntrega";
    String PUT_PEDIDOS_ATUALIZAR = "Pedido-v2-PutPedidosAtualizar";
    String POST_PEDIDOS_FORMA_PAGAMENTO_URA_ATUALIZAR = "Pedido-v2-PostPedidosFormaPagamentoUraAtualizar";
    String PUT_PEDIDOS_FORMA_PAGAMENTO_ATUALIZAR = "Pedido-v2-PutPedidosFormaPagamentoAtualizar";
    String PUT_PANVELGO_PEDIDO = "Pedido-v2-PutPanvelgoPedido";
    String PUT_PEDIDO_CANCELAR = "Pedido-v2-PutPedidoCancelar";
    String PUT_PEDIDO_STATUS = "Pedido-v2-PutPedidoStatus";
    String GET_PEDIDOS_CPF_HISTORICO = "Pedido-v2-GetPedidosCpfHistorico";
    String GET_PEDIDOS_CPF_PENDENTES = "Pedido-v2-GetPedidosCpfPendentes";
    String PATCH_PEDIDO_ITEM_DIGITADO = "Pedido-v2-PatchPedidoItemDigitado";
    String PATCH_PEDIDO_NUMERO_CUPOM = "Pedido-v2-PatchPedidoNumeroCupom";
    String GET_PEDIDOS = "Pedido-v2-GetPedidos";

    Runnable postPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDOS)).getServiceSpecs();
        String endpoint = "/v2/pedidos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDOS));
    };

    Runnable getPedido = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{pedido}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO));
    };

    Runnable getPedidosFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_FILIAL)).getServiceSpecs();
        String endpoint = "/v2/pedidos/filial/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_FILIAL));
    };

    Runnable getPedidoHistoricoStatus = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_HISTORICO_STATUS)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{numeroPedido}/historico/status";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_HISTORICO_STATUS));
    };

    Runnable postPedidosAvaliacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDOS_AVALIACAO)).getServiceSpecs();
        String endpoint = "/v2/pedidos/avaliacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDOS_AVALIACAO));
    };

    Runnable getPedidoAvaliacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_AVALIACAO)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{pedido}/avaliacao/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_AVALIACAO));
    };

    Runnable postMove = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDOS_MOVE)).getServiceSpecs();
        String endpoint = "/v2/pedidos/move";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDOS_MOVE));
    };



    Runnable getPedidosRetiradas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_RETIRADAS)).getServiceSpecs();
        String endpoint = "/v2/pedidos/retiradas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_RETIRADAS));
    };

    Runnable postPedidosRetiradas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDOS_RETIRADAS)).getServiceSpecs();
        String endpoint = "/v2/pedidos/retiradas/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDOS_RETIRADAS));
    };



    Runnable getPedidoGeoCoordenada = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_GEOCOORDENADA)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{numeroPedido}/geocooredenada";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_GEOCOORDENADA));
    };

    Runnable getPedidoPrevisaoEntrega = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_PREVISAO_ENTREGA)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{pedido}/previsaoentrega";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_PREVISAO_ENTREGA));
    };

    Runnable putPedidosAtualizar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PEDIDOS_ATUALIZAR)).getServiceSpecs();
        String endpoint = "/v2/pedidos/atualizar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PEDIDOS_ATUALIZAR));
    };

    Runnable postPedidosFormaPagamentoUraAtualizar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PEDIDOS_FORMA_PAGAMENTO_URA_ATUALIZAR)).getServiceSpecs();
        String endpoint = "/v2/pedidos/formaPagamentoUra/atualizar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PEDIDOS_FORMA_PAGAMENTO_URA_ATUALIZAR));
    };

    Runnable putPedidosFormaPagamentoAtualizar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PEDIDOS_FORMA_PAGAMENTO_ATUALIZAR)).getServiceSpecs();
        String endpoint = "/v2/pedidos/formaPagamento/atualizar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PEDIDOS_FORMA_PAGAMENTO_ATUALIZAR));
    };

    Runnable putPenvelgoPedido = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PANVELGO_PEDIDO)).getServiceSpecs();
        String endpoint = "/v2/panvelgo/{pedido}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PANVELGO_PEDIDO));
    };

    Runnable putPedidoCancelar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PEDIDO_CANCELAR)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{numeroPedido}/cancelar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PEDIDO_CANCELAR));
    };

    Runnable putPedidoStatus = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PEDIDO_STATUS)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{id}/status/{status}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PEDIDO_STATUS));
    };

    Runnable getPedidosCpfHistorico = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_CPF_HISTORICO)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{cpf}/historico";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_CPF_HISTORICO));
    };

    Runnable getPedidosCpfPendentes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS_CPF_PENDENTES)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{cpf}/historico";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS_CPF_PENDENTES));
    };

    Runnable patchPedidoItemDigitado = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_PEDIDO_ITEM_DIGITADO)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{numeroPedido}/item-digitado";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_PEDIDO_ITEM_DIGITADO));
    };

    Runnable patchPedidoNumeroCupom = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_PEDIDO_NUMERO_CUPOM)).getServiceSpecs();
        String endpoint = "/v2/pedidos/{numeroPedido}/numero-cupom/{numeroCupom}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_PEDIDO_NUMERO_CUPOM));
    };

    Runnable getPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDOS)).getServiceSpecs();
        String endpoint = "/v2/pedidos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDOS));
    };
}
