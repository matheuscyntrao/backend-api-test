package service.domino.receita;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Receitav1 extends ServiceBase {

    String dominio = "/receita";
    String url = Util.uri.apply("receita-service") + dominio;

    String GET_PRESCRITORES = "Receita-v1-GetPrescritores";
    String POST_PRESCRITORES = "Receita-v1-PostPrescritores";
    String GET_PRESCRITORES_CODIGOENTIDADE_ENDERECOS = "Receita-v1-GetPrescritoresCodigoEntidadeEnderecos";
    String POST_PRESCRITORES_CODIGOENTIDADE_ENDERECOS = "Receita-v1-PostPrescritoresCodigoEntidadeenderecos";
    String GET_REGRASRETENCAO = "Receita-v1-GetRegrasRetencao";
    String POST_RECEITAS = "Receita-v1-PostReceitas";
    String GET_RECEITAS_CODIGOCONVENIO_EXIGENCIA = "Receita-v1-GetReceitasCodigoConvenioExigencia";
    String GET_RECEITAS = "Receita-v1-GetReceitas";

    Runnable getPrescritores = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRESCRITORES)).getServiceSpecs();
        String endpoint = "/v1/prescritores/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRESCRITORES));
    };

    Runnable postPrescritores = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRESCRITORES)).getServiceSpecs();
        String endpoint = "/v1/prescritores/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRESCRITORES));
    };

    Runnable getPrescritoresCodigoEntidadeEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRESCRITORES_CODIGOENTIDADE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v1/prescritores/{codigoEntidade}/enderecos/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRESCRITORES_CODIGOENTIDADE_ENDERECOS));
    };

    Runnable postPrescritoresCodigoEntidadeEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRESCRITORES_CODIGOENTIDADE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v1/prescritores/{codigoEntidade}/enderecos/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRESCRITORES_CODIGOENTIDADE_ENDERECOS));
    };

    Runnable getRegrasRetencao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_REGRASRETENCAO)).getServiceSpecs();
        String endpoint = "/v1/regrasretencao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_REGRASRETENCAO));
    };

    Runnable postReceitas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_RECEITAS)).getServiceSpecs();
        String endpoint = "/v1/receitas/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_RECEITAS));
    };

    Runnable getReceitasCodigoConvenioExigencia = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_RECEITAS_CODIGOCONVENIO_EXIGENCIA)).getServiceSpecs();
        String endpoint = "/v1/receitas/{codigoConvenio}/exigencia";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_RECEITAS_CODIGOCONVENIO_EXIGENCIA));
    };

    Runnable getReceitas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_RECEITAS)).getServiceSpecs();
        String endpoint = "/v1/receitas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_RECEITAS));
    };
}
