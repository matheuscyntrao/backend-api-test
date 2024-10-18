package service.avengers.item;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Itemv3 extends ServiceBase {

    String dominio = "/item";
    String url = Util.uri.apply("item-service") + dominio;

    String GET_ITENS = "Item-v3-GetItens";
    String POST_ITENS_SEARCH = "Item-v3-PostItensSearch";
    String POST_ITENS_AVISEME = "Item-v3-PostItensAviseme";
    String GET_ITENS_AUTOCOMPLETE = "Item-v3-GetItensAutocomplete";
    String GET_ITENS_BASE_AUTOCOMPLETE = "Item-v3-GetItensBaseAutocomplete";
    String GET_VITRINES_CATEGORIA_ID = "Item-v3-GetVitrinesCategoriaId";
    String GET_VITRINES_CAMPANHA_ID = "Item-v3-GetVitrinesCampanhaId";
    String GET_VITRINES_HOME = "Item-v3-GetVitrinesHome";
    String GET_ITENS_REGRAS_FISCAIS = "Item-v3-GetItensRegrasFiscais";
    String GET_ITENS_CODIGO_CATEGORIA_LOJA_ESPECIAL = "Item-v3-GetItensCodigoCategoriaLojaEspecial";
    String GET_ITEM_CODIGO_ITEM_NOME = "Item-v3-GetItemCodigoItemNome";
    String GET_ITENS_NOME = "Item-v3-GetItensNome";
    String POST_PACKS_IDENTIFICACAO = "Item-v3-PostPacksIdentificacao";
    String POST_PACKS_IDENTIFICADOR = "Item-v3-PostPacksIdentificador";
    String PUT_ITENS_AVALIACAO = "Item-v3-PutItensAvaliacao";
    String GET_ITENS_AVALIACAO_ITEM_CODIGO_ITEM = "Item-v3-GetItensAvaliacaoItemCodigoItem";
    String GET_ITENS_AVALIACAO = "Item-v3-GetItensAvaliacao";
    String PATCH_ITENS_AVALIACAO = "Item-v3-PatchItensAvaliacao";
    String PUT_IAV = "Item-v3-PutIav";
    String GET_ITENS_IAV = "Item-v3-GetItensIav";
    String GET_ITENS_LISTA_IAV = "Item-v3-GetItensListaIav";
    String GET_ITENS_DETALHE_HTML = "Item-v3-GetItensDetalheHtml";
    String GET_ITENS_RELACIONADOS_CODIGO_ITEM = "Item-v3-GetItensRelacionadosCodigoItem";
    String GET_ITENS_SIMILARIDADE = "Item-v3-GetItensSimilaridade";
    String GET_ITENS_INFO_ADICIONAIS = "Item-v3-GetItensInfoAdicionais";
    String GET_ITENS_AVULSOS_CODIGO_ITEM = "Item-v3-GetItensAvulsosCodigoItem";
    String GET_ITENS_ATRIBUTOS = "Item-v3-GetItensAtributos";
    String GET_ITENS_DADOS_ITEM = "Item-v3-GetItensDadosItem";
    String GET_ITENS_DIMENSOES = "Item-v3-GetItensDimensoes";

    Runnable getItens = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS)).getServiceSpecs();
        String endpoint = "/v3/itens";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS));
    };

    Runnable postItensSearch = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ITENS_SEARCH)).getServiceSpecs();
        String endpoint = "/v3/itens/search";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ITENS_SEARCH));
    };

    Runnable postItensAviseme = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ITENS_AVISEME)).getServiceSpecs();
        String endpoint = "/v3/itens/aviseme";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ITENS_AVISEME));
    };

    Runnable getItensAutocomplete = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_AUTOCOMPLETE)).getServiceSpecs();
        String endpoint = "/v3/itens/autocomplete";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_AUTOCOMPLETE));
    };

    Runnable getItensBaseAutocomlpete = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_BASE_AUTOCOMPLETE)).getServiceSpecs();
        String endpoint = "/v3/itens/base/autocomplete/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_BASE_AUTOCOMPLETE));
    };

    Runnable getVitrinesCategoriaId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_VITRINES_CATEGORIA_ID)).getServiceSpecs();
        String endpoint = "/v3/vitrines/categoria/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_VITRINES_CATEGORIA_ID));
    };

    Runnable getVitrinesCampanhaId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_VITRINES_CAMPANHA_ID)).getServiceSpecs();
        String endpoint = "/v3/vitrines/campanha/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_VITRINES_CAMPANHA_ID));
    };

    Runnable getVitrinesHome = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_VITRINES_HOME)).getServiceSpecs();
        String endpoint = "/v3/vitrines/home";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_VITRINES_HOME));
    };

    Runnable getItensRegrasFiscais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_REGRAS_FISCAIS)).getServiceSpecs();
        String endpoint = "/v3/itens/regrasfiscais";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_REGRAS_FISCAIS));
    };

    Runnable getItensCodigoCategoriaLojaEspecial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_CODIGO_CATEGORIA_LOJA_ESPECIAL)).getServiceSpecs();
        String endpoint = "/v3/itens/{codigo_categoria}/loja/especial";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_CODIGO_CATEGORIA_LOJA_ESPECIAL));
    };

    Runnable getItemCodigoItemNome = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITEM_CODIGO_ITEM_NOME)).getServiceSpecs();
        String endpoint = "/v3/item/{codigo_item}/nome";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITEM_CODIGO_ITEM_NOME));
    };

    Runnable getItensNome = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_NOME)).getServiceSpecs();
        String endpoint = "/v3/itens/nome";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_NOME));
    };

    Runnable postPacksIdentificacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PACKS_IDENTIFICACAO)).getServiceSpecs();
        String endpoint = "/v3/packs/identificacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PACKS_IDENTIFICACAO));
    };

    Runnable postPacksIdentificador = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PACKS_IDENTIFICADOR)).getServiceSpecs();
        String endpoint = "/v3/packs/identificador";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PACKS_IDENTIFICADOR));
    };

    Runnable putItensAvaliacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_ITENS_AVALIACAO)).getServiceSpecs();
        String endpoint = "/v3/itens/avaliacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_ITENS_AVALIACAO));
    };

    Runnable getItensAvaliacaoItemCodigoItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_AVALIACAO_ITEM_CODIGO_ITEM)).getServiceSpecs();
        String endpoint = "/v3/itens/avaliacao/item/{codigoItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_AVALIACAO_ITEM_CODIGO_ITEM));
    };

    Runnable getItensAvaliacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_AVALIACAO)).getServiceSpecs();
        String endpoint = "/v3/itens/avaliacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_AVALIACAO));
    };

    Runnable pathItensAvaliacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_ITENS_AVALIACAO)).getServiceSpecs();
        String endpoint = "/v3/itens/avaliacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(PATCH_ITENS_AVALIACAO));
    };

    Runnable putIav = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_IAV)).getServiceSpecs();
        String endpoint = "/v3/iav";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_IAV));
    };

    Runnable getItensIav = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_IAV)).getServiceSpecs();
        String endpoint = "/v3/itens/iav";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_IAV));
    };

    Runnable getItensListaIav = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_LISTA_IAV)).getServiceSpecs();
        String endpoint = "/v3/itens/lista/iav";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_LISTA_IAV));
    };

    Runnable getItensDetalheHtml = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_DETALHE_HTML)).getServiceSpecs();
        String endpoint = "/v3/itens/detalhe-html";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_DETALHE_HTML));
    };

    Runnable getItensRelacionadosCodigoItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_RELACIONADOS_CODIGO_ITEM)).getServiceSpecs();
        String endpoint = "/v3/itens/relacionados/{codigoItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_RELACIONADOS_CODIGO_ITEM));
    };

    Runnable getItensSimilaridade = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_SIMILARIDADE)).getServiceSpecs();
        String endpoint = "/v3/itens/similaridade";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_SIMILARIDADE));
    };

    Runnable getItensInfoAdicionais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_INFO_ADICIONAIS)).getServiceSpecs();
        String endpoint = "/v3/itens/info-adicionais/";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_INFO_ADICIONAIS));
    };

    Runnable getItensAvulsosCodigoItem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_AVULSOS_CODIGO_ITEM)).getServiceSpecs();
        String endpoint = "/v3/itens/avulsos/{codigoItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_AVULSOS_CODIGO_ITEM));
    };

    Runnable getItensDadosAtributos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_ATRIBUTOS)).getServiceSpecs();
        String endpoint = "/v3/itens/dados/atributos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_ATRIBUTOS));
    };
    Runnable getItensDadosAtributoitem = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_DADOS_ITEM)).getServiceSpecs();
        String endpoint = "/v3/itens/dados/{atributoItem}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_DADOS_ITEM));
    };
    Runnable getItensDimensoes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ITENS_DIMENSOES)).getServiceSpecs();
        String endpoint = "/v3/itens/dimensoes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ITENS_DIMENSOES));
    };
}
