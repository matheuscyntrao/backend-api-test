package service.crossover.notificacao;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Notificacaov1 extends ServiceBase {

    String dominio = "/notificacao";
    String url = Util.uri.apply("notificacao-service") + dominio;

    String POST_NOTIFICACOES_SMS = "Notificacao-v1-PostNotificacoesSms";
    String POST_NOTIFICACOES_EMAIL_FILIAIS = "Notificacao-v1-PostNotificacoesEmailFiliais";
    String POST_NOTIFICACOES_EMAIL_FILIAIS_AMBULATORIO = "Notificacao-v1-PostNotificacoesEmailFiliaisAmbulatorio";
    String POST_NOTIFICACOES_EMAIL_FILIAIS_24HORAS = "Notificacao-v1-PostNotificacoesEmailFiliais24Horas";
    String POST_NOTIFICACOES_EMAIL_FIDELIDADE_EXTRATO = "Notificacao-v1-PostNotificacoesEmailFidelidadeExtrato";
    String POST_NOTIFICACOES_EMAIL_ULTIMAS_COMPRAS_CONVENIO = "Notificacao-v1-PostNotificacoesEmailUltimasComprasConvenio";
    String POST_NOTIFICACOES_PUSH = "Notificacao-v1-PostNotificacoesPush";
    String POST_NOTIFICACOES_STATUS = "Notificacao-v1-PostNotificacoesStatus";
    String POST_NOTIFICACAO_PEDIDO_STATUS = "Notificacao-v1-PostNotificacaoPedidoStatus";
    String POST_NOTIFICACAO = "Notificacao-v1-PostNotificacao";
    String GET_BLOQUEIO_CODIGO_CLIENTE = "Notificacao-v1-GetBloqueioCodigoCliente";
    String POST_NOTIFICACAO_PANVELGO = "Notificacao-v1-PostNotificacaoPanvelgo";

    Runnable postNotificacoesSms = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_SMS)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/sms";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_SMS));
    };

    Runnable postNotificacoesEmailFiliais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_EMAIL_FILIAIS)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/email/filiais";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_EMAIL_FILIAIS));
    };

    Runnable postNotificacoesEmailFiliaisAmbulatorio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_EMAIL_FILIAIS_AMBULATORIO)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/email/filiais/ambulatorio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_EMAIL_FILIAIS_AMBULATORIO));
    };

    Runnable postNotificacoesEmailFiliais24Horas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_EMAIL_FILIAIS_24HORAS)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/email/filiais/24horas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_EMAIL_FILIAIS_24HORAS));
    };

    Runnable postNotificacoesEmailFidelidadeExtrato = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_EMAIL_FIDELIDADE_EXTRATO)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/email/fidelidade/extrato";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_EMAIL_FIDELIDADE_EXTRATO));
    };

    Runnable postNotificacoesEmailUltimasComprasConvenio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_EMAIL_ULTIMAS_COMPRAS_CONVENIO)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/email/ultimascompras/convenio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_EMAIL_ULTIMAS_COMPRAS_CONVENIO));
    };

    Runnable postNotificacoesPush = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_PUSH)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/push/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_PUSH));
    };

    Runnable postNotificacoesStatus = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_STATUS)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/status";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_STATUS));
    };

    Runnable postNotificacaoPedidoStatus = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACAO_PEDIDO_STATUS)).getServiceSpecs();
        String endpoint = "/v1/notificacao/pedido/status";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACAO_PEDIDO_STATUS));
    };

    Runnable postNotificacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACAO)).getServiceSpecs();
        String endpoint = "/v1/notificacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACAO));
    };

    Runnable getBloqueioCodigoCliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BLOQUEIO_CODIGO_CLIENTE)).getServiceSpecs();
        String endpoint = "/v1/bloqueio/{codigoCliente}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BLOQUEIO_CODIGO_CLIENTE));
    };

    Runnable postNotificacaoPanvelgo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACAO_PANVELGO)).getServiceSpecs();
        String endpoint = "/v1/notificacao/panvelgo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACAO_PANVELGO));
    };
}
