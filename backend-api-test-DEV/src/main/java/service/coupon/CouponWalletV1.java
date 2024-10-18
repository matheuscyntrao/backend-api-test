package service.coupon;

import utils.Util;
import utils.service.BaseRequest;
import utils.service.Cache;
import utils.service.ServiceBase;
import utils.service.ServiceSpecs;

public interface CouponWalletV1 extends ServiceBase {

    String dominio = "/coupon";
    String url = Util.uri.apply("coupon-service") + dominio;

    String POST_COUPON_WALLET = "Coupon-v1-PostCouponWallet";
    String GET_COUPON_WALLET_PROMOCODE = "Coupon-v1-GetCouponWalletPromocode";
    String POST_COUPON_WALLET_PROMOCODE = "Coupon-v1-PostCouponWalletPromocode";
    String GET_COUPON_WALLET_EXPIRED = "Coupon-v1-GetCouponWalletExpired";
    String GET_COUPON_WALLET_RECOMMENDATION = "Coupon-v1-GetCouponWalletRecommendation";
    String PUT_COUPON_WALLET_REVERSE = "Coupon-v1-PutCouponWalletReverse";
    String GET_WALLET_INVALID_COUPONS = "Coupon-v1-GetWalletInvalidCoupons";

    Runnable postCouponWallet = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_COUPON_WALLET)).getServiceSpecs();
        String endpoint = "/v1/coupon/wallet";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint,specs.path)));
        BaseRequest.post.accept(specs,Util.rota.apply(POST_COUPON_WALLET));
    };

    Runnable getCouponWalletPromocode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_COUPON_WALLET_PROMOCODE)).getServiceSpecs();
        String endpoint = "/v1/coupon/wallet/cpf/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint,specs.path)));
        BaseRequest.get.accept(specs,Util.rota.apply(GET_COUPON_WALLET_PROMOCODE));
    };

    Runnable postCouponWalletPromocode = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(POST_COUPON_WALLET_PROMOCODE)).getServiceSpecs();
        String endpoint = "/v1/coupon/wallet/promocode";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint,specs.path)));
        BaseRequest.post.accept(specs,Util.rota.apply(POST_COUPON_WALLET_PROMOCODE));
    };

    Runnable getCouponWalletExpired = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_COUPON_WALLET_EXPIRED)).getServiceSpecs();
        String endpoint = "/v1/coupon/wallet/expired/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint,specs.path)));
        BaseRequest.get.accept(specs,Util.rota.apply(GET_COUPON_WALLET_EXPIRED));
    };

    Runnable getCouponWalletRecommendation = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_COUPON_WALLET_RECOMMENDATION)).getServiceSpecs();
        String endpoint = "/v1/coupon/wallet/recommendation/{cpf}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint,specs.path)));
        BaseRequest.get.accept(specs,Util.rota.apply(GET_COUPON_WALLET_RECOMMENDATION));
    };

    Runnable putCouponWalletReverse = () -> {
        ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(PUT_COUPON_WALLET_REVERSE)).getServiceSpecs();
        String endpoint = "/v1/coupon/wallet/reverse/{orderId}";
        specs.setUrl(url.concat(pathBuilder.apply(endpoint, specs.path)));
        BaseRequest.put.accept(specs, Util.rota.apply(PUT_COUPON_WALLET_REVERSE));
    };

    Runnable getWalletInvalidCoupons = () -> {
      ServiceSpecs specs = Cache.chamadas.get(Util.rota.apply(GET_WALLET_INVALID_COUPONS)).getServiceSpecs();
      String endpoint = "/v1/coupon/wallet/invalid/{cpf}";
      specs.setUrl(url.concat(pathBuilder.apply(endpoint,specs.path)));
      BaseRequest.get.accept(specs,Util.rota.apply(GET_WALLET_INVALID_COUPONS));
    };
}
