package service.avengers.desconto;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Descontov1 extends ServiceBase {

    String dominio = "/desconto";  //TODO: verificar depois
    String url = Util.uri.apply("desconto-service") + dominio;

    String POST_DESCONTO_CONVENIO_CARTAO_FILIAL_CEP_ENTREGA = "Desconto-v1-PostDescontoConvenioCartaoFilialCepEntrega";
    String POST_LIBERADORES_VALIDAR_ALCADA = "Desconto-v1-PostLiberadoresValidarAlcada";
    String POST_LIBERADORES_FRETE = "Desconto-v1-PostLiberadoresFrete";

    Runnable postdescontoConvenioCartaoFilialCepEntrega = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_DESCONTO_CONVENIO_CARTAO_FILIAL_CEP_ENTREGA)).getServiceSpecs();
        String endpoint = "/v1/desconto/convenio/{cartao}/{filial}/{cep}/{entrega}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_DESCONTO_CONVENIO_CARTAO_FILIAL_CEP_ENTREGA));
    };

    Runnable postLiberadoresValidarAlcada = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LIBERADORES_VALIDAR_ALCADA)).getServiceSpecs();
        String endpoint = "/v1/liberadores/validaralcada";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_LIBERADORES_VALIDAR_ALCADA));
    };

    Runnable postLiberadoresFrete = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_LIBERADORES_FRETE)).getServiceSpecs();
        String endpoint = "/v1/liberadores/frete";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_LIBERADORES_FRETE));
    };
}
