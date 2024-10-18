package service.avengers.filialVirtual;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface FilialVirtualv1 extends ServiceBase {

    String dominio = "/filialvirtual";
    String url = Util.uri.apply("filial-virtual-service") + dominio;

    String GET_PEDIDO_FILIAL = "FilialVirtual-v1-GetPedidoFilial";
    String GET_SALDO_DEVOLUCAO = "FilialVirtual-v1-GetSaldoDevolucao";
    String POST_NOTA = "FilialVirtual-v1-PostNota";
    String GET_UF = "FilialVirtual-v1-GetUf";
    String GET_CIDADES = "FilialVirtual-v1-GetCidades";
    String GET_BAIRROS = "FilialVirtual-v1-GetBairros";
    String GET_CANAIS = "FilialVirtual-v1-GetCanais";
    String GET_SUPERVISAO = "FilialVirtual-v1-GetSupervisao";
    String GET_FILIAIS = "FilialVirtual-v1-GetFiliais";
    String GET_PUBLICOS = "FilialVirtual-v1-GetPublicos";

    Runnable getPedidoFilial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PEDIDO_FILIAL)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/pedido/{pedido}/filial/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PEDIDO_FILIAL));
    };

    Runnable getSaldoDevolucao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SALDO_DEVOLUCAO)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/saldo/devolucao/{filial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SALDO_DEVOLUCAO));
    };

    Runnable postNota = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTA)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/nota";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTA));
    };

    Runnable getUf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_UF)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/uf";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_UF));
    };

    Runnable getCidades = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CIDADES)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/cidades";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CIDADES));
    };

    Runnable getBairros = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_BAIRROS)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/bairros";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_BAIRROS));
    };

    Runnable getCanais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CANAIS)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/canais";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CANAIS));
    };

    Runnable getSupervisao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_SUPERVISAO)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/areasupervisao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_SUPERVISAO));
    };

    Runnable getFiliais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAIS)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/filiais";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAIS));
    };

    Runnable getPublicos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PUBLICOS)).getServiceSpecs();
        String endpoint = "/v1/filialvirtual/publicos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PUBLICOS));
    };

}
