package service.timeB.pbmGatewayService;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface PbmGatewayService extends ServiceBase {

    String dominio = "/pbm-gateway";
    String url = Util.uri.apply("pbm-gateway") + dominio;
    //String url = "http://localhost:9044" + dominio;
    //String url = "http://172.16.21.38:9044" + dominio;


    String POST_ADESAO = "PbmGatewayService-v1-PostAdesao";
    String POST_PRE_AUTORIZACAO = "PbmGatewayService-v1-PostPreAutorizacao";
    String POST_AUTORIZACAO = "PbmGatewayService-v1-PostAutorizacao";
    String POST_CANCELAMENTO = "PbmGatewayService-v1-PostCancelamento";

    Runnable PostAdesao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADESAO)).getServiceSpecs();
        String endpoint = "/v1/adesao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADESAO));
    };

    Runnable PostPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v1/preautorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRE_AUTORIZACAO));
    };
    Runnable postAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v1/autorizacao/{identificadorTransacao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_AUTORIZACAO));
    };
    Runnable postCancelamento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CANCELAMENTO)).getServiceSpecs();
        String endpoint = "/v1/cancelamento/{identificadorTransacao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CANCELAMENTO));
    };
}
