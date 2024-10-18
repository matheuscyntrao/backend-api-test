package service.crossover.clienteVarejo;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface ClienteVarejoV1 extends ServiceBase {

    String dominio = "/clientevarejo";
    String url = Util.uri.apply("cliente-varejo-service") + dominio;

    String POST_CLIENTES_OPT_INS = "ClienteVarejo-v1-PostClientesOptIns";
    String GET_CLIENTES_OPT_INS_CPF = "ClienteVarejo-v1-GetClientesOptInsCpf";


    Runnable postClientesOptIns = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_OPT_INS)).getServiceSpecs();
        String endpoint = "/v1/clientes/opt-ins";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_OPT_INS));
    };

    Runnable getClientesOptInsCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_OPT_INS_CPF)).getServiceSpecs();
        String endpoint = "/v1/clientes/opt-ins/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_OPT_INS_CPF));
    };

}
