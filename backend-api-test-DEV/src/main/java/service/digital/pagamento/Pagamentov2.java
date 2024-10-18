package service.digital.pagamento;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pagamentov2 extends ServiceBase {

    String dominio = "/pagamento";
    String url = Util.uri.apply("pagamento-service") + dominio;

    String GET_PAGAMENTO_OPERACAO = "Pagamento-v2-GetPagamentoOperacao";
    String GET_PAGAMENTO_CONDICAO = "Pagamento-v2-GetPagamentoCondicao";
    String GET_PAGAMENTO_POS_FILIAL = "Pagamento-v2-GetPosFilial";
    String GET_PAGAMENTO_POS_FORMA_PAGAMENTO = "Pagamento-v2-GetPosFormaPagamento";

    Runnable getPagamentoOperacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_OPERACAO)).getServiceSpecs();
        String endpoint = "/v2/pagamentos/{operacao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_OPERACAO));
    };

    Runnable getPagamentoCondicao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_CONDICAO)).getServiceSpecs();
        String endpoint = "/v2/pagamentos/condicao/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_CONDICAO));
    };

    Runnable getPagamentoPosIdFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_POS_FILIAL)).getServiceSpecs();
        String endpoint = "/v2/pagamentos/pos/{idFilial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_POS_FILIAL));
    };

    Runnable getPagamentoPosFormaPagamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_POS_FORMA_PAGAMENTO)).getServiceSpecs();
        String endpoint = "/v2/pagamentos/pos/formaPagamento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_POS_FORMA_PAGAMENTO));
    };
}
