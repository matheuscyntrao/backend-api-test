package service.avengers.mostruario;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Mostriariov2 extends ServiceBase {

    String dominio = "/mostruario";
    String url = Util.uri.apply("mostruario-service") + dominio;

    String POST_ITENS = "Mostruario-v2-PostItens";
    String GET_BARCODE = "Mostruario-v2-GetBarcode";
    String POST_CONSULTAPRODUTO = "Mostruario-v2-ConsultaProduto";
    String POST_FILIAL = "Mostruario-v2-Filial";
    String GET_CODITEM = "Mostruario-v2-CodItem";

    Runnable postItens = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ITENS)).getServiceSpecs();
        String endpoint = "/v2/itens";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ITENS));
    };

    Runnable getBarcode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BARCODE)).getServiceSpecs();
        String endpoint = "/v2/itens/barcode={barcode}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BARCODE));
    };

    Runnable postConsultaProduto = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CONSULTAPRODUTO)).getServiceSpecs();
        String endpoint = "/v2/itens/consultaproduto";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CONSULTAPRODUTO));
    };

    Runnable postFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_FILIAL)).getServiceSpecs();
        String endpoint = "/v2/itens/filial";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_FILIAL));
    };

    Runnable getCodItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CODITEM)).getServiceSpecs();
        String endpoint = "/v2/itens/{codItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CODITEM));
    };

}
