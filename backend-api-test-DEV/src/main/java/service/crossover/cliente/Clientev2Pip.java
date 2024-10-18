package service.crossover.cliente;

import utils.UriProperties;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Clientev2Pip extends ServiceBase {

    String dominio = "/cliente";
    String url = Util.uri.apply("cliente-service") + dominio;

    String GET_CLIENTES = "Cliente-v2Pip-GetClientes";
    String POST_CLIENTES = "Cliente-v2Pip-PostClientes";
    String GET_CLIENTES_CPF_CPF = "Cliente-v2Pip-GetClientesCpfCpf";
    String PUT_CLIENTES_IDCLIENTE = "Cliente-v2Pip-PutClientesIdcliente";
    String DELETE_CLIENTES_IDCLIENTE_CONTATOS = "Cliente-v2Pip-DeleteClientesIdclienteContatos";
    String PUT_CLIENTES_IDCLIENTE_EMAILS = "Cliente-v2Pip-PutClientesIdclienteEmails";
    String GET_CLIENTES_IDCLIENTE_ENDERECOS = "Cliente-v2Pip-GetClientesIdclienteEnderecos";
    String POST_CLIENTES_IDCLIENTE_ENDERECOS = "Cliente-v2Pip-PostClientesIdclienteEnderecos";
    String GET_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v2Pip-GetClientesIdclienteEnderecosIdendereco";
    String PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v2Pip-PutClientesIdclienteEnderecosIdendereco";
    String DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO = "Cliente-v2Pip-DeleteClientesIdclienteEnderecosIdendereco";
    String PUT_CLIENTES_IDCLIENTE_TELEFONES = "Cliente-v2Pip-PutClientesIdclienteTelefones";
    String GET_CLIENTES_ID = "Cliente-v2Pip-GetClientesId";

    Runnable getClientes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES));
    };

    Runnable postClientes = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES));
    };

    Runnable getClientesCpfCpf = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_CPF_CPF)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/cpf/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_CPF_CPF));
    };

    Runnable putClientesIdcliente = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE));
    };

    Runnable deleteClientesIdclienteContatos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_CONTATOS)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/contatos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_CONTATOS));
    };

    Runnable putClientesIdclienteEmails = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_EMAILS)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/emails";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_EMAILS));
    };

    Runnable getClientesIdclienteEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/enderecos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS));
    };

    Runnable postClientesIdclienteEnderecos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_CLIENTES_IDCLIENTE_ENDERECOS)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/enderecos";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_CLIENTES_IDCLIENTE_ENDERECOS));
    };

    Runnable getClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable putClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable deleteClientesIdclienteEnderecosIdendereco = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/enderecos/{idEndereco}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_CLIENTES_IDCLIENTE_ENDERECOS_IDENDERECO));
    };

    Runnable putClientesIdclienteTelefones = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_CLIENTES_IDCLIENTE_TELEFONES)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{idCliente}/telefones";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_CLIENTES_IDCLIENTE_TELEFONES));
    };

    Runnable getClientesId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_CLIENTES_ID)).getServiceSpecs();
        String endpoint = "/v2/pip/clientes/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_CLIENTES_ID));
    };
}
