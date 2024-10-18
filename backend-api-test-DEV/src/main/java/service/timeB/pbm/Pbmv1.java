package service.timeB.pbm;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pbmv1 extends ServiceBase {

    String dominio = "/pbms";
    String url = Util.uri.apply("pbm-service") + dominio;

    String GET_PBM_PREFERENCIAL_ITEM = "Pbm-v1-GetPbmPreferencialItem";
    String POST_PBM_ITEM_PREFERENCIAL_COLLECTION = "Pbm-v1-PostPbmItemPreferencialCollection";
    String POST_PRE_AUTORIZACAO = "Pbm-v1-PostPreAutorizacao";
    String POST_CONFIRMACAO = "Pbm-v1-PostConfirmacao";
    String POST_EFETIVACAO = "Pbm-v1-PostEfetivacao";
    String POST_ANULACAO = "Pbm-v1-PostAnulacao";
    String GET_ITEM_TRANSACAO = "Pbm-v1-GetItemTransacao";
    String GET_LOGIN = "Pbm-v1-GetLogin";

    Runnable postPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PBM_PREFERENCIAL_ITEM)).getServiceSpecs();
        String endpoint = "/v1/getPbmPreferencialItem";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(GET_PBM_PREFERENCIAL_ITEM));
    };

    Runnable postGetPbmItemPrerefencialCollection = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PBM_ITEM_PREFERENCIAL_COLLECTION)).getServiceSpecs();
        String endpoint = "/v1/getPbmItemPreferencialCollection";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PBM_ITEM_PREFERENCIAL_COLLECTION));
    };

    Runnable postPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v1/preAutorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRE_AUTORIZACAO));
    };

    Runnable postConfirmacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONFIRMACAO)).getServiceSpecs();
        String endpoint = "/v1/confirmacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONFIRMACAO));
    };

    Runnable postEfetivacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EFETIVACAO)).getServiceSpecs();
        String endpoint = "/v1/efetivacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EFETIVACAO));
    };

    Runnable postAnulacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ANULACAO)).getServiceSpecs();
        String endpoint = "/v1/anulacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ANULACAO));
    };

    Runnable getIdTransacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_TRANSACAO)).getServiceSpecs();
        String endpoint = "/v1/getIdTransacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_TRANSACAO));
    };

    Runnable getLogin = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOGIN)).getServiceSpecs();
        String endpoint = "/v1/login";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOGIN));
    };
}
