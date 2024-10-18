package service.cupom;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Cupomv1 extends ServiceBase {

    String dominio = "/cupom";
    String url = Util.uri.apply("cupom-service") + dominio;

    String GET_FIDELIDADE_COMERCIAL = "Cupom-v1-GetFidelidadeComercial";
    String GET_OFERTA_CPF = "Cupom-v1-GetFidelidadeComercial";
    String GET_OFERTA_CLIENTE = "Cupom-v1-GetFidelidadeComercial";
    String GET_OFERTA = "Cupom-v1-GetFidelidadeComercial";

    Runnable getPedidoFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIDELIDADE_COMERCIAL)).getServiceSpecs();
        String endpoint = "/v1/fidelidade/{entidadeComercial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIDELIDADE_COMERCIAL));
    };

    Runnable getOfertaCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_OFERTA_CPF)).getServiceSpecs();
        String endpoint = "/v1/cupom-oferta/{oferta}/canal/{canalVenda}/filial/{codigoFilial}/cpf/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_OFERTA_CPF));
    };

    Runnable getOfertaCliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_OFERTA_CLIENTE)).getServiceSpecs();
        String endpoint = "/v1/cupom-oferta/canal/{canalVenda}/filial/{codigoFilial}/cliente/{cliente}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_OFERTA_CLIENTE));
    };

    Runnable getOferta = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_OFERTA)).getServiceSpecs();
        String endpoint = "/v1/cupom-oferta/oferta/{oferta}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_OFERTA));
    };

}
