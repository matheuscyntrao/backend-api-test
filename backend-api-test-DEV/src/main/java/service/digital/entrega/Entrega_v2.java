package service.digital.entrega;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Entrega_v2 extends ServiceBase {

    String dominio = "/entrega";
    String url = Util.uri.apply("entrega-service") + dominio;
    String POST_ENTREGAS = "Entrega-v2-PostEntregas";
    String GET_ENTREGA_VENDA_CEP = "Entrega-v2-GetEntregaVendaCep";
    String GET_PROXIMA_ABERTURA_CEP = "Entrega-v2-GetProximaAberturaCep";
    String GET_TAXAS = "Entrega-v2-GetTaxas";

    Runnable postPagamentoOperacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ENTREGAS)).getServiceSpecs();
        String endpoint = "/v2/entregas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ENTREGAS));
    };

    Runnable getEntregaVendaCep = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ENTREGA_VENDA_CEP)).getServiceSpecs();
        String endpoint = "/v2/entregavenda/{cep}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ENTREGA_VENDA_CEP));
    };

    Runnable getProximaAberturaCep = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PROXIMA_ABERTURA_CEP)).getServiceSpecs();
        String endpoint = "/v2/proximaabertura/{cep}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PROXIMA_ABERTURA_CEP));
    };

    Runnable getTaxas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_TAXAS)).getServiceSpecs();
        String endpoint = "/v2/taxas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_TAXAS));
    };

}
