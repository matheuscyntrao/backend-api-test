package service.timeB.skyhub;

import model.timeB.skyhub.request.AutenticacaoGerarTokenRequest;
import model.timeB.skyhub.request.OrderSetApproval;
import model.timeB.skyhub.response.AutenticacaoGerarTokenResponse;
import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

import java.util.function.Supplier;

public interface Skyhub extends ServiceBase {

    String dominio = "https://api.skyhub.com.br";

    String userEmail = "wwaszcenko@grupodimed.com.br";
    String accountManagerKey = "xk21bPa9jQ";
    String apiKey = "SnUHeqdxzgoP1z7rx5e_";

    String GET_FILIAIS = "Skyhub-v1-GetFiliais";
    String GET_FILIAIS_CODE = "Skyhub-v1-GetFiliaisCode";
    String PUT_FILIAL = "Skyhub-v1-PutFiliais";
    String GET_PRODUTOS = "Skyhub-v1-GetProdutos";
    String GET_PRODUTOS_CODE = "Skyhub-v1-GetProdutosCode";
    String POST_PRODUTO = "Skyhub-v1-PostProdutos";
    String PUT_PRODUTO = "Skyhub-v1-PutProdutos";
    String DELETE_PRODUTO = "Skyhub-v1-DeleteProdutos";
    String GET_QUEUES_ORDERS = "Skyhub-v1-QueuesOrders";
    String POST_ORDER = "Skyhub-v1-PostOrder";
    String GET_ORDERS = "Skyhub-v1-GetOrders";
    String POST_ORDER_APPROVAL = "Skyhub-v1-PostOrderApproval";


    Supplier<String> generateSkyhubToken = () -> {
        ServiceSpecs specs = new ServiceSpecs();
        String endpoint = "/auth";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        specs.setBody(AutenticacaoGerarTokenRequest.builder().api_key(apiKey).user_email(userEmail).build());
        return BaseRequest.post_withoutCache.apply(specs).getObjectBody(AutenticacaoGerarTokenResponse.class).getToken();
    };

    Runnable getFiliais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAIS)).getServiceSpecs();
        String endpoint = "/rehub/stores";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.header.put("Authorization", "Bearer " + Cache.tokenSkyHub);
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAIS));
    };

    Runnable getFiliaisCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_FILIAIS_CODE)).getServiceSpecs();
        String endpoint = "/rehub/stores/{code}";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.header.put("Authorization", "Bearer " + Cache.tokenSkyHub);
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_FILIAIS_CODE));
    };

    Runnable putFiliais = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_FILIAL)).getServiceSpecs();
        String endpoint = "/rehub/stores/{code}";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.header.put("Authorization", "Bearer " + Cache.tokenSkyHub);
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_FILIAL));
    };

    Runnable getProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRODUTOS)).getServiceSpecs();
        String endpoint = "/products";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRODUTOS));
    };

    Runnable getProdutosCode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_PRODUTOS_CODE)).getServiceSpecs();
        String endpoint = "/products/{code}";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_PRODUTOS_CODE));
    };

    Runnable postProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_PRODUTO)).getServiceSpecs();
        String endpoint = "/products";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_PRODUTO));
    };

    Runnable putProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_PRODUTO)).getServiceSpecs();
        String endpoint = "/products/{code}";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_PRODUTO));
    };

    Runnable deleteProdutos = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_PRODUTO)).getServiceSpecs();
        String endpoint = "/products/{code}";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_PRODUTO));
    };

    Runnable getQueuesOrders = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_QUEUES_ORDERS)).getServiceSpecs();
        String endpoint = "/queues/orders";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_QUEUES_ORDERS));
    };

    Runnable postOrder = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ORDER)).getServiceSpecs();
        String endpoint = "/orders";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ORDER));
    };

    Runnable postOrderApproval = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ORDER_APPROVAL)).getServiceSpecs();
        String endpoint = "/orders/{order}/approval";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "application/json");
        specs.header.put("Content-Type", "application/json");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        specs.setBody(OrderSetApproval.builder().status("payment_received").build());
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ORDER_APPROVAL));
    };

    Runnable getOrders = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ORDERS)).getServiceSpecs();
        String endpoint = "/orders";
        specs.header.put("x-user-email", userEmail);
        specs.header.put("x-accountmanager-key", accountManagerKey);
        specs.header.put("x-api-key", apiKey);
        specs.header.put("Accept", "*/*");
        specs.setUrl(dominio.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ORDERS));
    };
}
