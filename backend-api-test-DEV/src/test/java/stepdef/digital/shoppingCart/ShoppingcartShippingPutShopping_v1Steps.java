package stepdef.digital.shoppingCart;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.digital.shoppingCart.ShoppingCartGenerate;
import dataSource.mongo.shoppingCart.PaymentsDatastore;
import dataSource.mongo.shoppingCart.PickupSubsidiaryDatastore;
import dataSource.mongo.shoppingCart.ShoppingCartDatastore;
import entity.digital.shoppingCart.ShoppingCartEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.crossover.cliente.response.ClientesIdResponse_v2Pip;
import model.digital.shoppingCart.request.ShoppingRequest_v1;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1_Customer;
import model.digital.shoppingCart.response.ShoppingCartResponse_v1_Subsidiary;
import model.domino.filial.response.GetFilialIdResponse_v1;
import service.crossover.cliente.Clientev2Pip;
import service.digital.shoppingCart.ShoppingCart_v1;
import service.domino.filial.Filialv1;
import stepdef.crossover.cliente.GetPipClientes_v2Steps;
import stepdef.domino.filial.GetFiliaisFilial_v1Steps;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;


public class ShoppingcartShippingPutShopping_v1Steps {
    static String ROTA = ShoppingCart_v1.PUT_SHOPPING;

    @Dado("possuo dados para ShoppingCart - Shipping - PutShopping_v1:")
    public void possuo_dados_para_shopping_cart_shipping_put_shopping_v1(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), CucumberUtils.getObjectBody(dataTable, ShoppingRequest_v1.class));
    }

    @Quando("executo ShoppingCart - Shipping - PutShopping_v1")
    public void executo_shopping_cart_shipping_put_shopping_v1() {
        ShoppingCart_v1.putShopping.run();
    }

    @Entao("sistema processa ShoppingCart - Shipping - PutShopping_v1:")
    public void sistema_processa_shopping_cart_shipping_put_shopping_v1(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , ShoppingCartResponse_v1.class
        );
    }

    @Entao("valido ShoppingCart - Shipping - PutShopping_v1")
    public void valido_shopping_cart_shipping_put_shopping_v1() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {

            ShoppingRequest_v1 input = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(ShoppingRequest_v1.class);
            ShoppingCartResponse_v1 response = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class);

            ShoppingCartEntity entity = new ShoppingCartDatastore().getShoppingCartById(response.getShoppingCartId());

            new GetFiliaisFilial_v1Steps().runGetFilial(input.getSubsidiaryCode() == null ? 101 : input.getSubsidiaryCode());
            GetFilialIdResponse_v1 filialIdResponse_v1 = Cache.chamadas.get(Util.rota.apply(Filialv1.GET_FILIAIS_FILIAL)).getServiceResponse().getObjectBody(GetFilialIdResponse_v1.class);

            new GetPipClientes_v2Steps().runGetCliente(input.getCodCustomer());
            ClientesIdResponse_v2Pip clientesIdResponse_v2Pip = Cache.chamadas.get(Util.rota.apply(Clientev2Pip.GET_CLIENTES_ID)).getServiceResponse().getObjectBody(ClientesIdResponse_v2Pip.class);

            assertAll(
                    //subsidiary
                    () -> assertEquals(response.getSubsidiary(), ShoppingCartResponse_v1_Subsidiary.normalizarFilial(filialIdResponse_v1))
                    //customer
                    , () -> assertEquals(response.getCustomer(), ShoppingCartResponse_v1_Customer.normalizaCiente(clientesIdResponse_v2Pip))
                    , () -> assertEquals(response.getChannel().toString(), input.getChannel())
            );
        });
    }

    @After("@HookPutShopping_v1")
    public void delete() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            String shoppingCartId = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class).getShoppingCartId();
            try{
                new ShoppingCartDatastore().deleteById(shoppingCartId);
                new PaymentsDatastore().deleteById(shoppingCartId);
                new PickupSubsidiaryDatastore().deleteById(shoppingCartId);
            }catch (Exception e){
                System.out.println("Nao foi possivel fazer delete");
            }
        });
    }

    public void cadastroCarrinho(DataTable dataTable) throws JsonProcessingException {
        possuo_dados_para_shopping_cart_shipping_put_shopping_v1(dataTable);
        executo_shopping_cart_shipping_put_shopping_v1();
    }


    @Dado("que executo ShoppingCart - ShoppingCart - PutShopping_v1 {string}")
    public void que_executo_shopping_cart_shopping_cart_put_shopping_v1(String tipo) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), ShoppingCartGenerate.valueOf(tipo).pojo());
        executo_shopping_cart_shipping_put_shopping_v1();
        Cache.valores.put(Util.rota.apply("CARRINHO"), Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(ShoppingCartResponse_v1.class).getShoppingCartId());
    }
}
