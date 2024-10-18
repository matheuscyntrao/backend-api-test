package service.digital.pagamento;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pagamentov1 extends ServiceBase {

    String dominio = "/pagamento";
    String url = Util.uri.apply("pagamento-service") + dominio;

    String GET_PAGAMENTO_OPERACAO = "Pagamento-v1-GetPagamentoOperacao";
    String POST_PAGAMENTO_CONDICAO = "Pagamento-v1-PostPagamentoCondicao";
    String POST_PAGAMENTO_VALIDAR_CONVENIO_PRAZO = "Pagamento-v1-PostPagamentoValidarConvenioPrazo";

    Runnable getPagamentoOperacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_OPERACAO)).getServiceSpecs();
        String endpoint = "/v1/pagamentos/{operacao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_OPERACAO));
    };

    Runnable postPagamentoCondicao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PAGAMENTO_CONDICAO)).getServiceSpecs();
        String endpoint = "/v1/pagamentos/condicao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PAGAMENTO_CONDICAO));
    };

    Runnable postPagamentoValidarConvenioPrazo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PAGAMENTO_VALIDAR_CONVENIO_PRAZO)).getServiceSpecs();
        String endpoint = "/v1/pagamentos/validarconvenioprazo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PAGAMENTO_VALIDAR_CONVENIO_PRAZO));
    };
}
