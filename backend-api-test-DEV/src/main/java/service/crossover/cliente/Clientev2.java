package service.crossover.cliente;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Clientev2 extends ServiceBase {

    String dominio = "/cliente";
    String url = Util.uri.apply("cliente-service") + dominio;

    String GET_CARTAO_NUMEROCARTAO_VALIDAR = "Cliente-v2-GetCartaoNumerocartaoValidar";
    String POST_CLIENTES = "Cliente-v2-PostClientes";
    String GET_CLIENTES_ASSOCIADO_DETALHE_CPF = "Cliente-v2-GetClientesAssociadoDetalheCpf";
    String GET_CLIENTES_ASSOCIADO_ID = "Cliente-v2-GetClientesAssociadoId";
    String GET_CLIENTES_BASECENTRALIZADA_ID = "Cliente-v2-GetClientesBasecentralizadaId";
    String GET_CLIENTES_CARTAO = "Cliente-v2-GetClientesCartao";
    String PATCH_CLIENTES_CARTOES_IDCARTAO_NOME_NOME = "Cliente-v2-PatchClientesCartoesIdcartaoNomeNome";
    String GET_CLIENTES_CHEQUE = "Cliente-v2-GetClientesCheque";
    String POST_CLIENTES_CNPJ = "Cliente-v2-PostClientesCnpj";
    String GET_CLIENTES_CNPJ_CNPJ = "Cliente-v2-GetClientesCnpjCnpj";
    String GET_CLIENTES_INTERNET = "Cliente-v2-GetClientesInternet";
    String GET_CLIENTES_ORGAOSEMISSORES = "Cliente-v2-GetClientesOrgaosemissores";
    String GET_CLIENTES_PEDIDO_IDENTIFICADO_CODENTIDADECOMERCIAL = "Cliente-v2-GetClientesPedidoIdentificadoCodentidadecomercial";
    String GET_CLIENTES_SALDO = "Cliente-v2-GetClientesSaldo";
    String GET_CLIENTES_SERASA_CPF = "Cliente-v2-GetClientesSerasaCpf";
    String POST_CLIENTES_VALIDARHASH = "Cliente-v2-PostClientesValidarhash";
    String GET_CLIENTES_CODCLIENTE_CARTOES = "Cliente-v2-GetClientesCodclienteCartoes";
    String PATCH_CLIENTES_CODENTIDADECOMERCIAL_PJ = "Cliente-v2-PatchClientesCodentidadecomercialPj";
    String GET_CLIENTES_CPF_CONVENIOS = "Cliente-v2-GetClientesCpfConvenios";
    String GET_CLIENTES_CPF_REDEFINIRSENHA_DADOS = "Cliente-v2-GetClientesCpfRedefinirsenhaDados";
    String PUT_CLIENTES_IDCLIENTE = "Cliente-v2-PutClientesIdcliente";
    String POST_CLIENTES_IDCLIENTE_CARTOES = "Cliente-v2-PostClientesIdclienteCartoes";
    String DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO = "Cliente-v2-DeleteClientesIdclienteCartoesIdcartao";
    String PUT_CLIENTES_IDCLIENTE_CONTATOS = "Cliente-v2-PutClientesIdclienteContatos";
    String GET_CLIENTES_IDCLIENTE_CONTATOS_IDCONTATO = "Cliente-v2-GetClientesIdclienteContatosIdcontato";
    String GET_CLIENTES_IDCLIENTE_ENDERECOS = "Cliente-v2-GetClientesIdclienteEnderecos";
    String POST_CLIENTES_IDCLIENTE_ENDERECOS = "Cliente-v2-PostClientesIdclienteEnderecos";
    String PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v2-PutClientesIdclienteEnderecosEndereco";
    String DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v2-DeleteClientesIdclienteEnderecosEndereco";
    String PUT_CLIENTES_IDCLIENTE_SENHA = "Cliente-v2-PutClientesIdclienteSenha";
    String PUT_CLIENTES_IDCLIENTE_USUARIO = "Cliente-v2-PutClientesIdclienteUsuario";
    String GET_CLIENTES_IDENTIFICADOR_REDEFINIRSENHA = "Cliente-v2-GetClientesIdentificadorRedefinirsenha";
    String GET_CLIENTES_ID = "Cliente-v2-GetClientesId";
    String PUT_CLIENTES_ID_ATUALIZACAO = "Cliente-v2-PutClientesIdAtualizacao";
    String GET_CLIENTES_ID_ECMCLIENTE_EXISTE = "Cliente-v2-GetClientesIdEcmclienteExiste";
    String GET_CLIENTES_ID_KEYS = "Cliente-v2-GetClientesIdKeys";
    String PUT_INTOUCH_CLIENTES_GERARTOKEN = "Cliente-v2-PutIntouchClientesGerartoken";
    String GET_INTOUCH_CLIENTES_LOCALIZAR = "Cliente-v2-GetIntouchClientesLocalizar";

    Runnable getCartaoNumerocartaoValidar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CARTAO_NUMEROCARTAO_VALIDAR)).getServiceSpecs();
        String endpoint = "/v2/cartao/{numeroCartao}/validar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CARTAO_NUMEROCARTAO_VALIDAR));
    };

    Runnable postClientes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES)).getServiceSpecs();
        String endpoint = "/v2/clientes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES));
    };

    Runnable getClientesAssociadoDetalheCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ASSOCIADO_DETALHE_CPF)).getServiceSpecs();
        String endpoint = "/v2/clientes/associado/detalhe/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ASSOCIADO_DETALHE_CPF));
    };

    Runnable getClientesAssociadosId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ASSOCIADO_ID)).getServiceSpecs();
        String endpoint = "/v2/clientes/associado/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ASSOCIADO_ID));
    };

    Runnable getClientesBasecentralizadaId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_BASECENTRALIZADA_ID)).getServiceSpecs();
        String endpoint = "/v2/clientes/basecentralizada/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_BASECENTRALIZADA_ID));
    };

    Runnable getClientesCartao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CARTAO)).getServiceSpecs();
        String endpoint = "/v2/clientes/cartao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CARTAO));
    };

    Runnable patchClientesCartoesIdcartaoNomeNome = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_CLIENTES_CARTOES_IDCARTAO_NOME_NOME)).getServiceSpecs();
        String endpoint = "/v2/clientes/cartoes/{idCartao}/nome/{nome}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_CLIENTES_CARTOES_IDCARTAO_NOME_NOME));
    };

    Runnable getClientesCheque = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CHEQUE)).getServiceSpecs();
        String endpoint = "/v2/clientes/cheque";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CHEQUE));
    };

    Runnable postClientesCnpj = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_CNPJ)).getServiceSpecs();
        String endpoint = "/v2/clientes/cnpj";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_CNPJ));
    };

    Runnable getClientesCnpjCnpj = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CNPJ_CNPJ)).getServiceSpecs();
        String endpoint = "/v2/clientes/cnpj/{cnpj}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CNPJ_CNPJ));
    };

    Runnable getClientesInternet = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_INTERNET)).getServiceSpecs();
        String endpoint = "/v2/clientes/internet";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_INTERNET));
    };

    Runnable getClientesOrgaosemissores = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ORGAOSEMISSORES)).getServiceSpecs();
        String endpoint = "/v2/clientes/orgaos-emissores";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ORGAOSEMISSORES));
    };

    Runnable getClientesPedidoIdentificadoCodentidadecomercial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_PEDIDO_IDENTIFICADO_CODENTIDADECOMERCIAL)).getServiceSpecs();
        String endpoint = "/v2/clientes/pedido/identificado/{codEntidadeComercial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_PEDIDO_IDENTIFICADO_CODENTIDADECOMERCIAL));
    };

    Runnable getClientesSaldo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_SALDO)).getServiceSpecs();
        String endpoint = "/v2/clientes/saldo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_SALDO));
    };

    Runnable getClientesSerasaCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_SERASA_CPF)).getServiceSpecs();
        String endpoint = "/v2/clientes/serasa/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_SERASA_CPF));
    };

    Runnable postClientesValidarhash = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_VALIDARHASH)).getServiceSpecs();
        String endpoint = "/v2/clientes/validarhash";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_VALIDARHASH));
    };

    Runnable getClientesCodclienteCartoes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CODCLIENTE_CARTOES)).getServiceSpecs();
        String endpoint = "/v2/clientes/{codCliente}/cartoes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CODCLIENTE_CARTOES));
    };

    Runnable patchClientesCodentidadecomercialPj = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PATCH_CLIENTES_CODENTIDADECOMERCIAL_PJ)).getServiceSpecs();
        String endpoint = "/v2/clientes/{codEntidadeComercial}/pj";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.patch.accept(specs, Util.rota.apply(PATCH_CLIENTES_CODENTIDADECOMERCIAL_PJ));
    };

    Runnable getClientesCpfConvenios = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CPF_CONVENIOS)).getServiceSpecs();
        String endpoint = "/v2/clientes/{cpf}/convenios";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CPF_CONVENIOS));
    };

    Runnable getClientesCpfRedefinirsenhaDados = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CPF_REDEFINIRSENHA_DADOS)).getServiceSpecs();
        String endpoint = "/v2/clientes/{cpf}/redefinirsenha/dados";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CPF_REDEFINIRSENHA_DADOS));
    };

    Runnable putClientesIdcliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE));
    };

    Runnable postClientesIdclienteCartoes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_IDCLIENTE_CARTOES)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/cartoes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_IDCLIENTE_CARTOES));
    };

    Runnable deleteClientesIdclienteCartoesIdcartao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/cartoes/{idCartao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO));
    };

    Runnable putClientesIdclienteContatos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_CONTATOS)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/contatos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_CONTATOS));
    };

    Runnable getClientesIdclienteContatosIdcontato = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDCLIENTE_CONTATOS_IDCONTATO)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/contatos/{idContato}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDCLIENTE_CONTATOS_IDCONTATO));
    };

    Runnable getClientesIdclienteEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/enderecos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS));
    };

    Runnable postClientesIdclienteEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_IDCLIENTE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/enderecos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_IDCLIENTE_ENDERECOS));
    };

    Runnable putClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable deleteClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable putClientesIdclienteSenha = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_SENHA)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/senha";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_SENHA));
    };

    Runnable putClientesIdclienteUsuario = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_USUARIO)).getServiceSpecs();
        String endpoint = "/v2/clientes/{idCliente}/usuario";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_USUARIO));
    };

    Runnable getClientesIdentificadorRedefinirsenha = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDENTIFICADOR_REDEFINIRSENHA)).getServiceSpecs();
        String endpoint = "/v2/clientes/{identificador}/redefinirsenha";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDENTIFICADOR_REDEFINIRSENHA));
    };

    Runnable getClientesId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ID)).getServiceSpecs();
        String endpoint = "/v2/clientes/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ID));
    };

    Runnable putClientesIdAtualizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_ID_ATUALIZACAO)).getServiceSpecs();
        String endpoint = "/v2/clientes/{id}/atualizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_ID_ATUALIZACAO));
    };

    Runnable getClientesIdEcmclienteExiste = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ID_ECMCLIENTE_EXISTE)).getServiceSpecs();
        String endpoint = "/v2/clientes/{id}/ecm_cliente/existe";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ID_ECMCLIENTE_EXISTE));
    };

    Runnable getClientesIdKeys = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ID_KEYS)).getServiceSpecs();
        String endpoint = "/v2/clientes/{id}/keys";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ID_KEYS));
    };

    Runnable putIntouchClientesGerartoken = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_INTOUCH_CLIENTES_GERARTOKEN)).getServiceSpecs();
        String endpoint = "/v2/intouch/clientes/gerartoken";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_INTOUCH_CLIENTES_GERARTOKEN));
    };

    Runnable getIntouchClientesLocalizar = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_INTOUCH_CLIENTES_LOCALIZAR)).getServiceSpecs();
        String endpoint = "/v2/intouch/clientes/localizar";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_INTOUCH_CLIENTES_LOCALIZAR));
    };
}
