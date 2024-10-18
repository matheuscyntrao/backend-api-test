package service.plataforma.paymentGateway;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface Adminv1 extends ServiceBase {

    String dominio = "/payment-gateway";
    String url = Util.uri.apply("payment-gateway-service") + dominio;

    String GET_ADMIN_CARDAUTHORIZER = "PaymentGateway-Admin-CardAuthorizer";
    String POST_ADMIN_CARDAUTHORIZER = "PaymentGateway-Admin-PostAdminCardauthorizer";
    String PUT_ADMIN_CARDAUTHORIZER_ID = "PaymentGateway-Admin-PutAdminCardauthorizerId";
    String DELETE_ADMIN_CARDAUTHORIZER_ID = "PaymentGateway-Admin-DeleteAdminCardauthorizerId";
    String GET_ADMIN_PAYMENTGATEWAY = "PaymentGateway-Admin-GetAdminPaymentgateway";
    String POST_ADMIN_PAYMENTGATEWAY = "PaymentGateway-Admin-PostAdminPaymentgateway";
    String PUT_ADMIN_PAYMENTGATEWAY_ID = "PaymentGateway-Admin-PutAdminPaymentgatewayId";
    String DELETE_ADMIN_PAYMENTGATEWAY_ID = "PaymentGateway-Admin-DeleteAdminPaymentgatewayId";

    Runnable getAdminCardauthorizer = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_CARDAUTHORIZER)).getServiceSpecs();
        String endpoint = "/v1/admin/card-authorizer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_CARDAUTHORIZER));
    };

    Runnable postAdminCardAuthorizer = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADMIN_CARDAUTHORIZER)).getServiceSpecs();
        String endpoint = "/v1/admin/card-authorizer";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADMIN_CARDAUTHORIZER));
    };

    Runnable putAdminCardauthorizerId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_ADMIN_CARDAUTHORIZER_ID)).getServiceSpecs();
        String endpoint = "/v1/admin/card-authorizer/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_ADMIN_CARDAUTHORIZER_ID));
    };

    Runnable deleteAdminCardauthorizerId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_ADMIN_CARDAUTHORIZER_ID)).getServiceSpecs();
        String endpoint = "/v1/admin/card-authorizer/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_ADMIN_CARDAUTHORIZER_ID));
    };

    Runnable getAdminPaymentgateway = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_ADMIN_PAYMENTGATEWAY)).getServiceSpecs();
        String endpoint = "/v1/admin/payment-gateway";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.get.accept(specs, Util.rota.apply(GET_ADMIN_PAYMENTGATEWAY));
    };

    Runnable postAdminPaymentGateway = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_ADMIN_PAYMENTGATEWAY)).getServiceSpecs();
        String endpoint = "/v1/admin/payment-gateway";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.post.accept(specs, Util.rota.apply(POST_ADMIN_PAYMENTGATEWAY));
    };

    Runnable putAdminPaymentgatewayId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_ADMIN_PAYMENTGATEWAY_ID)).getServiceSpecs();
        String endpoint = "/v1/admin/payment-gateway/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_ADMIN_PAYMENTGATEWAY_ID));
    };

    Runnable deleteAdminPaymengatewayId = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(DELETE_ADMIN_PAYMENTGATEWAY_ID)).getServiceSpecs();
        String endpoint = "/v1/admin/payment-gateway/{id}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.delete.accept(specs, Util.rota.apply(DELETE_ADMIN_PAYMENTGATEWAY_ID));
    };
}
