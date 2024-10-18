package service.domino.convenio;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Conveniov2 extends ServiceBase {

    String dominio = "/convenio";
    String url = Util.uri.apply("convenio-service") + dominio;

    String GET_CONVENIOS = "Convenio-v2-GetConvenios";
    String PUT_CONVENIOS_ATUALIZARSENHA = "Convenio-v2-PutConveniosAtualizarsenha";
    String PUT_CONVENIO_BAIXAR_SALDO = "Convenio-v2-PostConvenioBaixarSaldo";
    String GET_CONVENIOS_CARTAO = "Convenio-v2-GetConveniosCartao";
    String POST_CONVENIO_DETALHAR = "Convenio-v2-PostConvenioDetalhar";
    String GET_CONVENIOS_INFORMACAO_ADMINISTRATIVO = "Convenio-v2-GetConveniosInformacaoAdministrativo";
    String GET_CONVENIOS_MATRICULA_DEPENDENTES = "Convenio-v2-GetConveniosMatriculaDependentes";
    String GET_CONVENIOS_ENTIDADECOMERCIAL = "Convenio-v2-GetConveniosEntidadecomercial";
    String POST_CONVENIOSPRAZO_AUTENTICACAO = "Convenio-v2-PostConveniosprazoAutenticacao";
    String PATCH_CONVENIOSPRAZO_DESBLOQUEIOCARTAO = "Convenio-v2-PatchConveniosprazoDesbloqueiocartao";
    String POST_CONVENIOSPRAZO_VALIDAR = "Convenio-v2-PostConveniosprazoValidar";
    String POST_CONVENIOSPRAZO_CONVENIO_DOCUMENTOS = "Convenio-v2-PostConveniosprazoConvenioDocumentos";
    String GET_CONVENIOSPRAZO_NUMEROCARTAO_EXTRATO = "Convenio-v2-GetConveniosprazoNumerocartaoExtrato";
    String POST_ESTORNASALDOCONVENIO = "Convenio-v2-PostEstornasaldoconvenio";

    Runnable getConvenio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONVENIOS)).getServiceSpecs();
        String endpoint = "/v2/convenios";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONVENIOS));
    };

    Runnable putConveniosAtualizarsenha = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CONVENIOS_ATUALIZARSENHA)).getServiceSpecs();
        String endpoint = "/v2/convenios/atualizasenha";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CONVENIOS_ATUALIZARSENHA));
    };

    Runnable postConvenioDetalhar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONVENIO_DETALHAR)).getServiceSpecs();
        String endpoint = "/v2/convenios/detalhar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONVENIO_DETALHAR));
    };

    Runnable getConveniosCartao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONVENIOS_CARTAO)).getServiceSpecs();
        String endpoint = "/v2/convenios/cartao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONVENIOS_CARTAO));
    };

    Runnable putConvenioBaixarSaldo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CONVENIO_BAIXAR_SALDO)).getServiceSpecs();
        String endpoint = "/v2/convenios/baixasaldo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CONVENIO_BAIXAR_SALDO));
    };

    Runnable getConveniosInformacaoAdministrativo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONVENIOS_INFORMACAO_ADMINISTRATIVO)).getServiceSpecs();
        String endpoint = "/v2/convenios/{convenio}/informacao/administrativo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONVENIOS_INFORMACAO_ADMINISTRATIVO));
    };

    Runnable getConveniosMatriculaDependentes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONVENIOS_MATRICULA_DEPENDENTES)).getServiceSpecs();
        String endpoint = "/v2/convenios/{convenio}/{matricula}/dependentes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONVENIOS_MATRICULA_DEPENDENTES));
    };

    Runnable getConveniosEntidadecomercial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONVENIOS_ENTIDADECOMERCIAL)).getServiceSpecs();
        String endpoint = "/v2/convenios/{entidadeComercial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONVENIOS_ENTIDADECOMERCIAL));
    };

    Runnable postConveniosprazoAutenticacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONVENIOSPRAZO_AUTENTICACAO)).getServiceSpecs();
        String endpoint = "/v2/conveniosprazo/autenticacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONVENIOSPRAZO_AUTENTICACAO));
    };

    Runnable patchConveniosprazoDesbloqueiocartao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_CONVENIOSPRAZO_DESBLOQUEIOCARTAO)).getServiceSpecs();
        String endpoint = "/v2/conveniosprazo/desbloqueiocartao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_CONVENIOSPRAZO_DESBLOQUEIOCARTAO));
    };

    Runnable postConveniosprazoValidar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONVENIOSPRAZO_VALIDAR)).getServiceSpecs();
        String endpoint = "/v2/conveniosprazo/validar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONVENIOSPRAZO_VALIDAR));
    };

    Runnable postConveniosprazoConvenioDocumentos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONVENIOSPRAZO_CONVENIO_DOCUMENTOS)).getServiceSpecs();
        String endpoint = "/v2/conveniosprazo/{convenio}/documentos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONVENIOSPRAZO_CONVENIO_DOCUMENTOS));
    };

    Runnable getConveniosprazoNumerocartaoExtrato = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CONVENIOSPRAZO_NUMEROCARTAO_EXTRATO)).getServiceSpecs();
        String endpoint = "/v2/conveniosprazo/{numeroCartao}/extrato";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CONVENIOSPRAZO_NUMEROCARTAO_EXTRATO));
    };

    Runnable postEstornaSaldoConvenio = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ESTORNASALDOCONVENIO)).getServiceSpecs();
        String endpoint = "/v2/estorna-saldo-convenio";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ESTORNASALDOCONVENIO));
    };
}
