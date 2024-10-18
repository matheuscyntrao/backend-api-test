package service.timeB.pbm;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Pbmv2 extends ServiceBase {

    String dominio = "/pbms";
    String url = Util.uri.apply("pbm-service") + dominio;

    String GET_PBM_PREFERENCIAL_ITEM = "Pbm-v2-GetPbmPreferencialItem";
    String POST_PBM_ITEM_PREFERENCIAL_COLLECTION = "Pbm-v2-PostPbmItenPreferencialCollection";
    String POST_PRE_AUTORIZACAO = "Pbm-v2-PostPreAutorizacao";
    String POST_CONFIRMACAO = "Pbm-v2-PostConfirmacao";
    String POST_EFETIVACAO = "Pbm-v2-PostEfetivacao";
    String POST_ANULACAO = "Pbm-v2-PostAnulacao";
    String GET_ID_TRANSACAO = "Pbm-v2-GetIdTransacao";
    String GET_LOGIN = "Pbm-v2-GetLogin";
    String POST_EPHARMA_PRE_AUTORIZACAO = "Pbm-v2-PostEpharmaPreAutorizacao";
    String GET_FUNCIONAL_AVALIAR_ELEGIBILIDADE = "Pbm-v2-GetFuncionalAvaliarElegibilidade";
    String POST_FUNCIONAL_CADASTRO_UNICO = "Pbm-v2-PostFuncionalCadastroUnico";
    String POST_FUNCIONAL_AUTENTICACAO = "Pbm-v2-PostFuncionalAutenticacao";

    Runnable postPedidos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PBM_PREFERENCIAL_ITEM)).getServiceSpecs();
        String endpoint = "/v2/getPbmPreferencialItem";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(GET_PBM_PREFERENCIAL_ITEM));
    };

    Runnable postPbmItemPreferencialCollection = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PBM_ITEM_PREFERENCIAL_COLLECTION)).getServiceSpecs();
        String endpoint = "/v2/getPbmItemPreferencialCollection";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PBM_ITEM_PREFERENCIAL_COLLECTION));
    };

    Runnable postPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v2/preAutorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRE_AUTORIZACAO));
    };

    Runnable postConfirmacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONFIRMACAO)).getServiceSpecs();
        String endpoint = "/v2/confirmacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONFIRMACAO));
    };

    Runnable postEfetivacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EFETIVACAO)).getServiceSpecs();
        String endpoint = "/v2/efetivacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EFETIVACAO));
    };

    Runnable postAnulacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ANULACAO)).getServiceSpecs();
        String endpoint = "/v2/anulacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ANULACAO));
    };

    Runnable getIdTransacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ID_TRANSACAO)).getServiceSpecs();
        String endpoint = "/v2/getIdTransacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ID_TRANSACAO));
    };

    Runnable getLogin = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_LOGIN)).getServiceSpecs();
        String endpoint = "/v2/login";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_LOGIN));
    };

    Runnable postEpharmaPreAutorizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_EPHARMA_PRE_AUTORIZACAO)).getServiceSpecs();
        String endpoint = "/v2/epharma/preAutorizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_EPHARMA_PRE_AUTORIZACAO));
    };

    Runnable getFuncionalAvaliarElegibilidade = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FUNCIONAL_AVALIAR_ELEGIBILIDADE)).getServiceSpecs();
        String endpoint = "/v2/funcional/avaliar-elegibilidade";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FUNCIONAL_AVALIAR_ELEGIBILIDADE));
    };

    Runnable postFuncionalCadastroUnico = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_CADASTRO_UNICO)).getServiceSpecs();
        String endpoint = "/v2/funcional/cadastro-unico";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_CADASTRO_UNICO));
    };

    Runnable postFuncionalAutenticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FUNCIONAL_AUTENTICACAO)).getServiceSpecs();
        String endpoint = "/v2/funcional/autenticacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FUNCIONAL_AUTENTICACAO));
    };
}
