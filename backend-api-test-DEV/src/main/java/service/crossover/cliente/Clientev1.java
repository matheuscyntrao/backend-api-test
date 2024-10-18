package service.crossover.cliente;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Clientev1 extends ServiceBase {

    String dominio = "/cliente";
    String url = Util.uri.apply("cliente-service") + dominio;

    String POST_CLIENTES = "Cliente-v1-PostClientes";
    String GET_CLIENTES_ASSOCIADO_DETALHE_CPF = "Cliente-v1-GetClientesAssociadoDetalheCpf";
    String GET_CLIENTES_ASSOCIADO_ID = "Cliente-v1-GetClientesAssociadoId";
    String GET_CLIENTES_BASECENTRALIZADA_ID = "Cliente-v1-GetClientesBasecentralizadaId";
    String GET_CLIENTES_PEDIDO_IDENTIFICADO_CODENTIDADECOMERCIAL = "Cliente-v1-GetClientesPedidoIdentificadoCodentidadecomercial";
    String GET_CLIENTES_SALDO = "Cliente-v1-GetClientesSaldo";
    String GET_CLIENTES_SERASA_CPF = "Cliente-v1-GetClientesSerasaCpf";
    String GET_CLIENTES_CODCLIENTE_CARTOES = "Cliente-v1-GetClientesCodclienteCartoes";
    String GET_CLIENTES_CPF_CONVENIOS = "Cliente-v1-GetClientesCpfConvenios";
    String PUT_CLIENTES_IDCLIENTE = "Cliente-v1-PutClientesIdcliente";
    String POST_CLIENTES_IDCLIENTE_CARTOES = "Cliente-v1-PostClientesIdclienteCartoes";
    String DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO = "Cliente-v1-DeleteClientesIdclienteCartoesIdcartao";
    String PUT_CLIENTES_IDCLIENTE_CONTATOS = "Cliente-v1-PutClientesIdclienteContatos";
    String GET_CLIENTES_IDCLIENTE_ENDERECOS = "Cliente-v1-GetClientesIdclienteEnderecos";
    String POST_CLIENTES_IDCLIENTE_ENDERECOS = "Cliente-v1-PostClientesIdclienteEnderecos";
    String PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v1-PutClientesIdclienteEnderecosIdendereco";
    String DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v1-DeleteClientesIdclienteEnderecosIdendereco";
    String PUT_CLIENTES_IDCLIENTE_SENHA = "Cliente-v1-PutClientesIdclienteSenha";
    String PUT_CLIENTES_IDCLIENTE_USUARIO = "Cliente-v1-PutClientesIdclienteUsuario";
    String GET_CLIENTES_IDENTIFICADOR_REDEFINIRSENHA = "Cliente-v1-GetClientesIdentificadorRedefinirsenha";
    String GET_CLIENTES_ID = "Cliente-v1-GetClientesId";
    String PUT_CLIENTES_ID_ATUALIZACAO = "Cliente-v1-PutClientesIdAtualizacao";
    String POST_NOTIFICACOES_SMS = "Cliente-v1-PostNotificacoesSms";

    Runnable postClientes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES)).getServiceSpecs();
        String endpoint = "/v1/clientes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES));
    };

    Runnable getClientesAssociadoDetalheCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ASSOCIADO_DETALHE_CPF)).getServiceSpecs();
        String endpoint = "/v1/clientes/associado/detalhe/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ASSOCIADO_DETALHE_CPF));
    };

    Runnable getClientesAssociadoId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ASSOCIADO_ID)).getServiceSpecs();
        String endpoint = "/v1/clientes/associado/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ASSOCIADO_ID));
    };

    Runnable getClientesBasecentralizadaId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_BASECENTRALIZADA_ID)).getServiceSpecs();
        String endpoint = "/v1/clientes/basecentralizada/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_BASECENTRALIZADA_ID));
    };

    Runnable getClientesPedidoIdentificadoCodentidadecomercial = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_PEDIDO_IDENTIFICADO_CODENTIDADECOMERCIAL)).getServiceSpecs();
        String endpoint = "/v1/clientes/pedido/identificado/{codEntidadeComercial}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_PEDIDO_IDENTIFICADO_CODENTIDADECOMERCIAL));
    };

    Runnable getClientesSaldo = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_SALDO)).getServiceSpecs();
        String endpoint = "/v1/clientes/saldo";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_SALDO));
    };

    Runnable getClientesSerasaCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_SERASA_CPF)).getServiceSpecs();
        String endpoint = "/v1/clientes/serasa/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_SERASA_CPF));
    };

    Runnable getClientesCodclienteCartoes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CODCLIENTE_CARTOES)).getServiceSpecs();
        String endpoint = "/v1/clientes/{codCliente}/cartoes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CODCLIENTE_CARTOES));
    };

    Runnable getClientesCpfConvenios = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CPF_CONVENIOS)).getServiceSpecs();
        String endpoint = "/v1/clientes/{cpf}/convenios";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CPF_CONVENIOS));
    };

    Runnable putClientesIdcliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE));
    };

    Runnable postClientesIdclienteCartoes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_IDCLIENTE_CARTOES)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/cartoes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_IDCLIENTE_CARTOES));
    };

    Runnable deleteClientesIdclienteCartoesIdcartao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/cartoes/{idCartao}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_CARTOES_IDCARTAO));
    };

    Runnable putClientesIdclienteContatos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_CONTATOS)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/contatos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_CONTATOS));
    };

    Runnable getClientesIdclienteEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/enderecos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS));
    };

    Runnable postClientesIdclienteEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_IDCLIENTE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/enderecos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_IDCLIENTE_ENDERECOS));
    };

    Runnable putClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable deleteClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable putClientesIdclienteSenha = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_SENHA)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/senha";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_SENHA));
    };

    Runnable putClientesIdclienteUsuario = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_USUARIO)).getServiceSpecs();
        String endpoint = "/v1/clientes/{idCliente}/usuario";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_USUARIO));
    };

    Runnable getClientesIdentificadorRedefinirsenha = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDENTIFICADOR_REDEFINIRSENHA)).getServiceSpecs();
        String endpoint = "/v1/clientes/{identificador}/redefinirsenha";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDENTIFICADOR_REDEFINIRSENHA));
    };

    Runnable getClientesId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ID)).getServiceSpecs();
        String endpoint = "/v1/clientes/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ID));
    };

    Runnable putClientesIdAtualizacao = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_ID_ATUALIZACAO)).getServiceSpecs();
        String endpoint = "/v1/clientes/{id}/atualizacao";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_ID_ATUALIZACAO));
    };

    Runnable postNotificacoesSms = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_NOTIFICACOES_SMS)).getServiceSpecs();
        String endpoint = "/v1/notificacoes/sms";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_NOTIFICACOES_SMS));
    };
}
