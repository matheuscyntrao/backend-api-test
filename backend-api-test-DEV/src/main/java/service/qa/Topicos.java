package service.qa;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Topicos extends ServiceBase {

    String dominio = "/qa-service";  //TODO: verificar depois
    String url = "http://giedi100.dimed.com.br:8090".concat(dominio);

    String GET_PEDIDO_TOPICO = "Qa-Pedido-GetPedidoTopico";

    Runnable getPedidoTopico = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_TOPICO)).getServiceSpecs();
        String endpoint = "/{pedido}/{topico}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_TOPICO));
    };


}
