package service.domino.fidelidade;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Fidelidadev1 extends ServiceBase {

    String dominio = "/fidelidade";
    String url = Util.uri.apply("fidelidade-service") + dominio;

    String GET_FIDELIDADES_IDENTIFICADOR = "Fidelidade-v1-GetFidelidadesIdentificador";
    String POST_FIDELIDADES_CPF_REDEFINIRSENHA = "Fidelidade-v1-PostFidelidadesCpfRedefinirSenha";
    String GET_FIDELIDADES_SALDOFIDELIDADE_NUMBER = "Fidelidade-v1-GetFidelidadesSaldoFidelidadeNumber";
    String GET_FIDELIDADES_CPF_EXTRATO = "Fidelidade-v1-GetFidelidadesCpfExtrato";
    String GET_FIDELIDADES_CPF_MULTIPLUS_INFO = "Fidelidade-v1-GetFidelidadesCpfMultiplusInfo";
    String POST_FIDELIDADES_CPF_MULTIPLUS_TRANSFERIR = "Fidelidade-v1-PostFidelidadesCpfMultiplusTransferir";
    String POST_FIDELIDADES_CPF_RESGATEDISPONIVEL = "Fidelidade-v1-PostFidelidadesCpfResgateDisponivel";
    String POST_FIDELIDADES_CPF_USUARIOVALIDO = "Fidelidade-v1-PostFidelidadesCpfUsuarioValido";
    String POST_FIDELIDADES_IDENTIFICADOR_ADESAO = "Fidelidade-v1-PostFidelidadesIdentificadorAdesao";
    String POST_FIDELIDADE_ADESAO = "Fidelidade-v1-PostFidelidadeAdesao";
    String POST_FIDELIDADES_PONTUAR = "Fidelidade-v1-PostFidelidadesPontuar";
    String POST_FIDELIDADE_MOVIMENTO = "Fidelidade-v1-PostFidelidadeMovimento";
    String POST_FIDELIDADE_CARTAO_SEGUNDAVIA = "Fidelidade-v1-PostFidelidadeCartaoSegundaVia";
    String PUT_FIDELIDADE_CONFIRMACAOMENSAGEM = "Fidelidade-v1-PutFidelidadeConfirmacaoMensagem";
    String POST_FIDELIDADE_ESTORNO = "Fidelidade-v1-PostFidelidadeEstorno";

    Runnable getFidelidadesIdentificador = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIDELIDADES_IDENTIFICADOR)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{identificador}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIDELIDADES_IDENTIFICADOR));
    };

    Runnable postFidelidadeCpfRedefinirSenha = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADES_CPF_REDEFINIRSENHA)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{cpf}/redefinirsenha";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADES_CPF_REDEFINIRSENHA));
    };

    Runnable postFidelidadesSaldoFidelidadeNumber = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIDELIDADES_SALDOFIDELIDADE_NUMBER)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/saldoFidelidade/{number}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(GET_FIDELIDADES_SALDOFIDELIDADE_NUMBER));
    };

    Runnable getFidelidadesCpfExtrato = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIDELIDADES_CPF_EXTRATO)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{cpf}/extrato";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIDELIDADES_CPF_EXTRATO));
    };

    Runnable getFidelidadesCpfMultiplusInfo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FIDELIDADES_CPF_MULTIPLUS_INFO)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{cpf}/multiplus/info";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FIDELIDADES_CPF_MULTIPLUS_INFO));
    };

    Runnable postFidelidadesCpfMultiplusTransferir = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADES_CPF_MULTIPLUS_TRANSFERIR)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{cpf}/multiplus/transferir";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADES_CPF_MULTIPLUS_TRANSFERIR));
    };

    Runnable postFidelidadesCpfResgateDisponivel = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADES_CPF_RESGATEDISPONIVEL)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{cpf}/resgatedisponivel";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADES_CPF_RESGATEDISPONIVEL));
    };

    Runnable postFidelidadesCpfUsuarioValido = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADES_CPF_USUARIOVALIDO)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{cpf}/usuariovalido";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADES_CPF_USUARIOVALIDO));
    };

    Runnable postFidelidadesIdentificadorAdesao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADES_IDENTIFICADOR_ADESAO)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/{identificador}/adesao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADES_IDENTIFICADOR_ADESAO));
    };

    Runnable postFidelidadeAdesao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADE_ADESAO)).getServiceSpecs();
        String endpoint = "/v1/fidelidade/adesao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADE_ADESAO));
    };

    Runnable postFidelidadesPontuar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADES_PONTUAR)).getServiceSpecs();
        String endpoint = "/v1/fidelidades/pontuar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADES_PONTUAR));
    };

    Runnable postFidelidadeMovimento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADE_MOVIMENTO)).getServiceSpecs();
        String endpoint = "/v1/fidelidade/movimento";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADE_MOVIMENTO));
    };

    Runnable postFidelidadeCartaoSegundaVia = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADE_CARTAO_SEGUNDAVIA)).getServiceSpecs();
        String endpoint = "/v1/fidelidade/cartao/segunda-via";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADE_CARTAO_SEGUNDAVIA));
    };

    Runnable putFidelidadeConfirmacaoMensagem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_FIDELIDADE_CONFIRMACAOMENSAGEM)).getServiceSpecs();
        String endpoint = "/v1/fidelidade/confirmacao-mensagem";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_FIDELIDADE_CONFIRMACAOMENSAGEM));
    };

    Runnable postFidelidadeEstorno = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FIDELIDADE_ESTORNO)).getServiceSpecs();
        String endpoint = "/v1/fidelidade/estorno";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FIDELIDADE_ESTORNO));
    };
}
