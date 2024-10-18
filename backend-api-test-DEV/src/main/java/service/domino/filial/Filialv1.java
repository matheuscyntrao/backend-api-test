package service.domino.filial;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Filialv1 extends ServiceBase {

    String dominio = "/filial";
    String url = Util.uri.apply("filial-service") + dominio;

    String GET_FILIAIS = "Filial-v1-GetFilial";
    String POST_FILIAIS_CONSULTA = "Filial-v1-PostFiliaisConsulta";
    String POST_FILIAL_ATENDIMENTO = "Filial-v1-PostFilialAtendimento";
    String POST_FILIAL_DISPONIBILIDADE = "Filial-v1-PostFilialDisponibilidade";
    String GET_FILIAL_ESTOQUE_ITEM = "Filial-v1-GetFilialEstoqueItem";
    String GET_FILIAL_FUNCIONAMENTO_LOCKER_ID_DATA = "Filial-v1-GetFilialFuncionamentoLockerIdData";
    String GET_FILIAL_FUNCIONAMENTO_CODIGO_FILIAL = "Filial-v1-GetFilialFuncionamentoCodigoFilial";
    String GET_FILIAL_FUNCIONAMENTO_CODIGO_FILIAL_DATA = "Filial-v1-GetFilialFuncionamentoCodigoFilialData";
    String GET_FILIAL_FUNCIONARIO_USUARIO_LIBERADAS = "Filial-v1-GetFilialFuncionarioUsiarioLiberadas";
    String GET_FILIAL_LOCALIDADE_CEP = "Filial-v1-GetFilialLocalidadecep";
    String GET_FILIAL_LOCALIDADE_LATITUDE_LONGITUDE = "Filial-v1-GetFilialLocalidadeLatitudeLongitude";
    String GET_FILIAIS_FILIAL = "Filial-v1-GetFiliaisFilial";
    String GET_FILIAL_ESTOQUE = "Filial-v1-GetFilialEstoque";
    String GET_FILIAL_ESTOQUE_ALO_PANVEL = "Filial-v1-GetFilialEstoqueAloPanvel";
    String GET_FILIAL_RETIRADA_BALCAO = "Filial-v1-GetFilialRetiradaBalcao";
    String GET_FILIAL_CEP = "Filial-v1-GetFilialCep";
    String POST_FILIAIS_ESTOQUE = "Filial-v1-PostFiliaisEstoque";
    String GET_FILIAIS_ESTOQUE_CODITEM = "Filial-v1-GetFiliaisEstoqueCodItem";


    Runnable getFiliais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAIS)).getServiceSpecs();
        String endpoint = "/v1/filiais";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAIS));
    };

    Runnable postFiliaisConsulta = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FILIAIS_CONSULTA)).getServiceSpecs();
        String endpoint = "/v1/filiais/consulta";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FILIAIS_CONSULTA));
    };

    Runnable postFiliaisAtendimento = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FILIAL_ATENDIMENTO)).getServiceSpecs();
        String endpoint = "/v1/filiais/atendimento/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FILIAL_ATENDIMENTO));
    };

    Runnable postFiliaisDisponibilidade = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FILIAL_DISPONIBILIDADE)).getServiceSpecs();
        String endpoint = "/v1/filiais/disponibilidade/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FILIAL_DISPONIBILIDADE));
    };

    Runnable getFilialEstoqueCodItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_ESTOQUE_ITEM)).getServiceSpecs();
        String endpoint = "/v1/filiais/estoque/{codItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_ESTOQUE_ITEM));
    };

    Runnable getFilialFuncionamentoLockerIdData = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_FUNCIONAMENTO_LOCKER_ID_DATA)).getServiceSpecs();
        String endpoint = "/v1/filiais/funcionamento/locker/{idLocker}/{data}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_FUNCIONAMENTO_LOCKER_ID_DATA));
    };

    Runnable getFilialFuncionamentoCodigoFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_FUNCIONAMENTO_CODIGO_FILIAL)).getServiceSpecs();
        String endpoint = "/v1/filiais/funcionamento/{codigoFilial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_FUNCIONAMENTO_CODIGO_FILIAL));
    };

    Runnable getFilialFuncionamentoCodigoFilialData = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_FUNCIONAMENTO_CODIGO_FILIAL_DATA)).getServiceSpecs();
        String endpoint = "/v1/filiais/funcionamento/{codigoFilial}/{data}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_FUNCIONAMENTO_CODIGO_FILIAL_DATA));
    };

    Runnable getFilialFuncionarioUsuarioLiberadas = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_FUNCIONARIO_USUARIO_LIBERADAS)).getServiceSpecs();
        String endpoint = "/v1/filiais/funcionario/{usuario}/liberadas";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_FUNCIONARIO_USUARIO_LIBERADAS));
    };

    Runnable getFilialLocalidadeCep = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_LOCALIDADE_CEP)).getServiceSpecs();
        String endpoint = "/v1/filiais/localidade/{cep}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_LOCALIDADE_CEP));
    };

    Runnable getLocalidadeLatitudeLongitude = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_LOCALIDADE_LATITUDE_LONGITUDE)).getServiceSpecs();
        String endpoint = "/filiais/localidade/{latitude}/{longitude}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_LOCALIDADE_LATITUDE_LONGITUDE));
    };

    Runnable getFiliaisFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAIS_FILIAL)).getServiceSpecs();
        String endpoint = "/v1/filiais/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAIS_FILIAL));
    };

    Runnable getFilialEstoque = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_ESTOQUE)).getServiceSpecs();
        String endpoint = "/v1/filiais/{filial}/estoque/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_ESTOQUE));
    };

    Runnable getFilialEstoqueAloPanvel = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_ESTOQUE_ALO_PANVEL)).getServiceSpecs();
        String endpoint = "/v1/filiais/{filial}/estoque/alopanvel";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_ESTOQUE_ALO_PANVEL));
    };

    Runnable getFilialRetiradaBalcao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_RETIRADA_BALCAO)).getServiceSpecs();
        String endpoint = "/v1/filial/retiradabalcao/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_RETIRADA_BALCAO));
    };

    Runnable getFilialCep = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAL_CEP)).getServiceSpecs();
        String endpoint = "/v1/filial/{cep}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAL_CEP));
    };

    Runnable postFiliaisEstoque = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FILIAIS_ESTOQUE)).getServiceSpecs();
        String endpoint = "/v1/filiais/estoque";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FILIAIS_ESTOQUE));
    };

    Runnable getFiliaisEstoqueCodItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAIS_ESTOQUE_CODITEM)).getServiceSpecs();
        String endpoint = "/v1/filiais/estoque/{codItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAIS_ESTOQUE_CODITEM));
    };
}
