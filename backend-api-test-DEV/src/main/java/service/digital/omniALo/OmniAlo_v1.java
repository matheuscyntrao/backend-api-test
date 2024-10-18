package service.digital.omniALo;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface OmniAlo_v1 extends ServiceBase {

    String dominio = "/omnialo";
    String url = Util.uri.apply("omnialo-backend") + dominio;
    String POST_AUTENTICACAO = "OmniAlo-v1-PostAutenticacao";
    String GET_AUTENTICACAO = "OmniAlo-v1-GetAutenticacao";
    String GET_FILIAL = "OmniAlo-v1-Getfilial";
    String GET_PAGAMENTO_POS_FILIAL = "OmniAlo-v1-GetPagamentoPosFilial";
    String GET_AUTENTICACAO_USUARIO = "OmniAlo-v1-GetAutenticacaoUsuario";
    String GET_PAGAMENTO_POS = "OmniAlo-v1-GetPagamentoPos";
    String GET_FIDELIDADE = "OmniAlo-v1-GetFidelidade";
    String GET_EXTRATO = "OmniAlo-v1-GetExtrato";

    Runnable postAutenticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_AUTENTICACAO)).getServiceSpecs();
        String endpoint = "/autenticacao/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_AUTENTICACAO));
    };

    Runnable getAutenticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_AUTENTICACAO)).getServiceSpecs();
        String endpoint = "/autenticacao/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_AUTENTICACAO));
    };

    Runnable getFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL)).getServiceSpecs();
        String endpoint = "/filial/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL));
    };
    Runnable getPagamentoPosFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_POS_FILIAL)).getServiceSpecs();
        String endpoint = "/pagamento/pos/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_POS_FILIAL));
    };
    Runnable getAutenticacaoUsuario = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_AUTENTICACAO_USUARIO)).getServiceSpecs();
        String endpoint = "/autenticacao/usuario/{codigoUsuario}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_AUTENTICACAO_USUARIO));
    };
    Runnable getFormaPagamentoPos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PAGAMENTO_POS)).getServiceSpecs();
        String endpoint = "/pagamento/pos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PAGAMENTO_POS));
    };
    Runnable getFidelidade = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIDELIDADE)).getServiceSpecs();
        String endpoint = "/fidelidade/{documento}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIDELIDADE));
    };
    Runnable getExtrato = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_EXTRATO)).getServiceSpecs();
        String endpoint = "/fidelidade/{cpf}/extrato";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_EXTRATO));
    };
}
