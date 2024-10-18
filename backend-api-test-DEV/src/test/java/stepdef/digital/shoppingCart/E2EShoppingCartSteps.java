package stepdef.digital.shoppingCart;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import model.digital.shoppingCart.enums.PaymentMethodEnum;
import model.digital.shoppingCart.enums.ShippingMethodEnum;
import model.digital.shoppingCart.request.PatchPaymentsCashRequest_v1;
import model.digital.shoppingCart.request.PatchShippingPickupRequest_v1;
import model.digital.shoppingCart.request.ShoppingRequest_v1;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import org.junit.Assert;
import service.digital.shoppingCart.ShoppingCart_v1;
import utils.CucumberUtils;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class E2EShoppingCartSteps {
    @Dado("que executo ShoppingCart - ShoppingCart - PutShopping_v1:")
    public void que_executo_shopping_cart_shopping_cart_put_shopping_v1(DataTable dataTable) throws JsonProcessingException {
        new ShoppingcartShippingPutShopping_v1Steps().cadastroCarrinho(dataTable);
    }

    @Dado("que adiciono ShoppingCart - ShoppingCart - PostItemCodItem:")
    public void que_adiciono_shopping_cart_shopping_cart_post_item_cod_item(DataTable dataTable) {
        new PatchShoppingcartItemCodItemSteps().adicionoItens(dataTable.asMaps(), Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PUT_SHOPPING)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class).getShoppingCartId());
    }

    @Dado("que adiciono ShoppingCart - Shipping - PatchPickup:")
    public void que_adiciono_shopping_cart_shipping_patch_pickup(DataTable dataTable) throws JsonProcessingException {
        PatchShippingPickupRequest_v1 body = dataTable == null ? PatchShippingPickupRequest_v1.generate() : CucumberUtils.getObjectBody(dataTable, PatchShippingPickupRequest_v1.class);
        new PathShippingPickup_v1Steps().executo(body, getShoppingcartId());
    }

    @Dado("que efetuo ShoppingCart - Payment - PatchCash total")
    public void que_efetuo_shopping_cart_payment_patchcash_total(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> path = Map.of("shoppingCartCode", getShoppingcartId());
    }

    @Dado("que verifico ShoppingCart - Shipping - GetPickup {string}")
    public void que_verifico_shopping_cart_shipping_get_pickup(String subsidiaryId) {
        new GetShippingPickupSteps().executo(Map.of("shoppingCartId", getShoppingcartId()), Map.of("subsidiaries", subsidiaryId));
    }

    @Dado("que verifico ShoppingCart - Payment - GetPayments")
    public void que_verifico_shopping_cart_payment_get_payments() {
        new GetPaymentPaymentsSteps().executo(Map.of("shoppingCartCode", getShoppingcartId()));
    }

    @Dado("seleciono ShoppingCart - Shipping - {string}")
    public void seleciono_shopping_cart_shipping(String string) {
        ShippingMethodEnum shippingMethodEnum = ShippingMethodEnum.valueOf(string);
        assumingThat(shippingMethodEnum.equals(ShippingMethodEnum.PICKUP), () -> {
            que_verifico_shopping_cart_shipping_get_pickup("701");
            que_adiciono_shopping_cart_shipping_patch_pickup(null);
        });
        assumingThat(shippingMethodEnum.equals(ShippingMethodEnum.DELIVERY), () -> {
            //TODO:Codar
        });
        assumingThat(shippingMethodEnum.equals(ShippingMethodEnum.LOCKER), () -> {
            //TODO:Codar
        });
    }

    @Dado("efetuo ShoppingCart - Payment - {string} de {double}%")
    public void efetuo_shopping_cart_payment_de(String paymentMethod, Double percent) {
        PaymentMethodEnum paymentMethodEnum = PaymentMethodEnum.valueOf(paymentMethod);
        new GetShoppingcartShoppingShoppingcartidSteps().executo(Map.of("shoppingCartId", getShoppingcartId()));
        ShoppingCartResponse_v1 response_v1 = Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.GET_SHOPPING)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class);
        BigDecimal valorTotal = response_v1.getCartTotals().getTotal();
        BigDecimal valorPagar = valorTotal.multiply(BigDecimal.valueOf(percent / 100)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        que_verifico_shopping_cart_payment_get_payments();

        Map<String, String> path = Map.of("shoppingCartCode", getShoppingcartId());
        assumingThat(paymentMethodEnum.equals(PaymentMethodEnum.CASH), () -> {
            new PatchPaymentsCash_v1Steps().executo(PatchPaymentsCashRequest_v1.builder().givenValue(valorTotal).paymentMethodValue(valorPagar).build(), path);
        });
        assumingThat(paymentMethodEnum.equals(PaymentMethodEnum.BANKSLIP), () -> {
            //TODO:Codar
        });
        assumingThat(paymentMethodEnum.equals(PaymentMethodEnum.CONVENANT_CARD), () -> {
            //TODO:Codar
        });
        assumingThat(paymentMethodEnum.equals(PaymentMethodEnum.CREDIT), () -> {
            //TODO:Codar
        });
        assumingThat(paymentMethodEnum.equals(PaymentMethodEnum.DEBIT), () -> {
            //TODO:Codar
        });
    }

    private String getShoppingcartId() {
        return Cache.chamadas.get(Util.rota.apply(ShoppingCart_v1.PUT_SHOPPING)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class).getShoppingCartId();
    }


    @Dado("que efetuo ShoppingCart - ShoppingCart - PutShopping_v1")
    public void que_efetuo_shopping_cart_shopping_cart_put_shopping_v1() {
        BuilderRequest.body.accept(Util.rota.apply(ShoppingCart_v1.PUT_SHOPPING), ShoppingRequest_v1.builder().channel("SITE").subsidiaryCode(701).build());
        ShoppingCart_v1.putShopping.run();
    }

    @Dado("que adiciono ShoppingCart - ShoppingCart - PostItemCodItem {string}")
    public void que_adiciono_shopping_cart_shopping_cart_post_item_cod_item(String itemList) {
        String itens[] = itemList.split(",");
        Arrays.stream(itens).forEach(item -> {
            System.out.println("Chamar enum do ".concat(item));
        });
    }

    @Dado("que removo ShoppingCart - ShoppingCart - PostItemCodItem {string}")
    public void que_removo_shopping_cart_shopping_cart_post_item_cod_item(String string) {

    }

    @Entao("valido tabelas de PBM")
    public void valido_tabelas_de_pbm() {

    }



}
