package stepdef.digital.shippingService;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.digital.shipping.*;
import entity.digital.shipping.FilialCentralizadoraPorCepEntity;
import entity.digital.shipping.FilialContingenciaPorCepEntity;
import entity.digital.shipping.FilialPorCepEntity;
import entity.digital.shipping.RegrasEntregaEntity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.digital.shippingService.request.*;
import model.digital.shippingService.response.PostDeliveriesResponse_v1;
import model.digital.shippingService.response.PostDeliveriesResponse_v1_Deliveries;
import org.testng.Assert;
import queries.digital.shipping.FilialPorCep;
import queries.digital.shipping.RegrasEntrega;
import service.digital.shippingService.ShippingService_v1;
import utils.CucumberUtils;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class PostDeliveries_v1Steps {

    private static String ROTA = ShippingService_v1.POST_DELIVERIES;

    @Dado("que possuo dados para ShippingService - v1 - PostDeliveries:")
    public void que_possuo_dados_para_shipping_service_v1_post_deliveries(DataTable dataTable) throws JsonProcessingException {
        PostDeliveriesRequest_v1 body = CucumberUtils.getObjectBody(dataTable, PostDeliveriesRequest_v1.class);
        body.setDate(LocalDate.now().plusDays(Long.parseLong(body.getDate())).toString().concat("T10:00:00"));
        BuilderRequest.body.accept(Util.rota.apply(ROTA), body);
    }

    @E("possuo dados para ShippingService - v1 - PostDeliveries address:")
    public void e_possuo_dados_para_shipping_service_v1_post_deliveries_address(DataTable dataTable) throws JsonProcessingException {
        PostDeliveriesRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostDeliveriesRequest_v1.class);
        body.setAddress(CucumberUtils.getObjectBody(dataTable, PostDeliveriesRequest_v1_Address.class));
        Cache.valores.put(Util.rota.apply("zipCode"), body.getAddress().getZipCode());
        assumingThat(body.getAddress().getZipCode().split("\\D").length == 0 && !body.getAddress().getZipCode().equals("null"), () -> {
            body.getAddress().setZipCode(PostDeliverieCepGenerate.valueOf(body.getAddress().getZipCode()).pojo());
            // body.getAddress().setPlaceCode(PostDeliverieCepGenerate.valueOf(body.getAddress().getPlaceCode().toString()).pojo());
        });
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @E("possuo dados para ShippingService - v1 - PostDeliveries customer:")
    public void e_possuo_dados_para_shipping_service_v1_post_deliveries_customer(DataTable dataTable) throws JsonProcessingException {
        PostDeliveriesRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostDeliveriesRequest_v1.class);
        body.setCustomer(CucumberUtils.getObjectBody(dataTable, PostDeliveriesRequest_v1_Customer.class));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @E("possuo dados para ShippingService - v1 - PostDeliveries items:")
    public void e_possuo_dados_para_shipping_service_v1_post_deliveries_items(DataTable dataTable) throws JsonProcessingException {
        PostDeliveriesRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostDeliveriesRequest_v1.class);
        body.setItems(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostDeliveriesRequest_v1_Items[].class).clone()));
        body.getItems().get(0).setCode(PostItensGenerate.valueOf(body.getItems().get(0).getCodeEnum()).pojo());
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @E("possuo dados para ShippingService - v1 - PostDeliveries items groupers:")
    public void e_possuo_dados_para_shipping_service_v1_post_deliveries_items_groupers(DataTable dataTable) throws JsonProcessingException {
        PostDeliveriesRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostDeliveriesRequest_v1.class);
        body.getItems().get(0).setGroupers(Arrays.asList(CucumberUtils.getObjectBody(dataTable, PostDeliveriesRequest_v1_Items_Groupers[].class).clone()));
        Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().setBody(body);
    }

    @Quando("executo PostDeliveries - v1 - PostDeliveries")
    public void executo_post_deliveries_v1_post_deliveries() {
        ShippingService_v1.postDeliveries.run();
    }

    @Entao("sistema processa PostDeliveries - v1 - PostDeliveries:")
    public void sistema_processa_post_deliveries_v1_post_deliveries(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse()
                , PostDeliveriesResponse_v1[].class
        );
    }


    @Entao("valido PostDeliveries - v1 - PostDeliveries desconto {string}")
    public void valido_post_deliveries_v1_post_deliveries_desconto(String descontoEsperado) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            List<PostDeliveriesResponse_v1> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostDeliveriesResponse_v1[].class).clone());
            assumingThat(descontoEsperado.isEmpty(), () -> {
                Assert.assertNull(response.get(0).getDeliveries().get(EntregaTypeEnum.valueOf(Cache.valores.get(Util.rota.apply("zipCode"))).getValue()).getTax().getDiscount());
            });
            assumingThat(!descontoEsperado.isEmpty(), () -> {
                Assert.assertEquals(response.get(0).getDeliveries().get(EntregaTypeEnum.valueOf(Cache.valores.get(Util.rota.apply("zipCode"))).getValue()).getTax().getDiscount().getDescription(), descontoEsperado, "Descricao do desconto incorreta !");
            });
        });
    }

    @Entao("valido PostDeliveries - v1 - PostDeliveries {string}")
    public void valido_post_deliveries_v1_post_deliveries(String string) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            validaTypeEntrega(string, true);
        });
    }

    @Entao("valido PostDeliveries bloqueio - v1 - PostDeliveries {string}")
    public void valido_post_deliveries_bloqueio_v1_post_deliveries(String string) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            validaTypeEntrega(string, false);
        });
    }
    @Dado("que possuo dados para ShippingService - v1 - PostDeliveries valido")
    public void que_possuo_dados_para_shipping_service_v1_post_deliveries_valido() {
        BuilderRequest.body.accept(Util.rota.apply(ROTA), PostDeliverieRequestGenerate.SHIPPING_VALIDO.pojo());
    }

    @Entao("valido PostDeliveries - v1 - PostDeliveries filial do cep")
    public void valido_post_deliveries_v1_post_deliveries_filial_do_cep() {
        String cep = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostDeliveriesRequest_v1.class).getAddress().getZipCode();
        List<FilialPorCepEntity> filialDoCep = FilialPorCep.getFilialDoCep(cep);
        List<FilialPorCepEntity> filiaisCorreio = FilialPorCep.getFiliaisCorreio(cep);
        assumingThat(filialDoCep.size() > 0, () -> {
            validaRetornoFilialPorCep(filialDoCep);
            validaTypeEntrega("PROGRAMADA-MOTOBOY,RAPIDA-MOTOBOY", true);
        });
        assumingThat(filiaisCorreio.size() > 0, () -> {
            validaRetornoFilialPorCep(filiaisCorreio);
            validaTypeEntrega("PAC-PAC,SEDEX-SEDEX", true);
        });
    }

    @Entao("valido PostDeliveries - v1 - PostDeliveries filial de {string} do cep")
    public void valido_post_deliveries_v1_post_deliveries_filial_de_contingencia_do_cep(String tipoFilial) {
        List<PostDeliveriesResponse_v1> responseList = Arrays.asList(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostDeliveriesResponse_v1[].class).clone());
        assumingThat(tipoFilial.equals("CONTINGENCIA"), () -> {
            List<FilialContingenciaPorCepEntity> filialContingencia = FilialPorCep.getFilialContingencia();
            assumingThat(filialContingencia.size() > 0, () -> {
                assertAll(
                        () -> assertEquals(filialContingencia.get(0).getFilial_contingencia(), responseList.get(0).getDeliveries().get(0).getSubsidiary().getCode())
                );
            });
        });
        assumingThat(tipoFilial.equals("CENTRALIZADORA"), () -> {
            List<FilialCentralizadoraPorCepEntity> filialCentralizadora = FilialPorCep.getFilialCentralizadora();
            assumingThat(filialCentralizadora.size() > 0, () -> {
                assertAll(
                        () -> assertEquals(responseList.get(0).getDeliveries().get(0).getSubsidiary().getCode(), filialCentralizadora.get(0).getFilial_centralizadora(), "Filial centralizadora errada "),
                        () -> assertTrue(responseList.get(0).getDeliveries().get(1).getSubsidiary().getCode() != responseList.get(0).getDeliveries().get(0).getSubsidiary().getCode())
                );
            });
        });
    }

    private void validaRetornoFilialPorCep(List<FilialPorCepEntity> filiais) {
        List<PostDeliveriesResponse_v1> response = Arrays.asList(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostDeliveriesResponse_v1[].class).clone());
        filiais.stream().forEach(filial -> {
            Optional<PostDeliveriesResponse_v1_Deliveries> filtrado = response.get(0).getDeliveries().stream().filter(
                    filtro -> filtro.getSubsidiary().getCode().equals(Long.parseLong(filial.getFilial()))
            ).findAny();
            Optional<PostDeliveriesResponse_v1_Deliveries> filtradoDiferente = response.get(0).getDeliveries().stream().filter(
                    filtro -> filtro.getSubsidiary().getCode() != Long.parseLong(filial.getFilial())
            ).findAny();
            assertAll(
                    () -> assertFalse(filtrado.isEmpty(), "veio filtrado")
                    , () -> assertTrue("veio filial igual", filtradoDiferente.isEmpty())
            );
        });
    }

    @Entao("valido ShippingService - v1 - regra para isentar entrega")
    public void valido_shipping_service_v1_regra_para_isentar_entrega() {
        PostDeliveriesRequest_v1 body = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceSpecs().getObjectBody(PostDeliveriesRequest_v1.class);
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            List<RegrasEntregaEntity> regrasEntrega = RegrasEntregaGenerate.valueOf(Cache.valores.get(Util.rota.apply("zipCode"))).pojo();
            assumingThat(regrasEntrega.get(0).getRegra_valor_isenta() == null, () -> {
                assertAll(
                        () -> assertTrue(regrasEntrega.get(0).getFilial_valor_isenta() != regrasEntrega.get(0).getRegra_valor_isenta())
                );
            });
            System.out.println("Não possui regra de entrega");
        });
    }

    @Entao("valido ShippingService - v1 - regra de prazo de entrega")
    public void valido_shipping_service_v1_regra_de_prazo_de_entrega() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            List<RegrasEntregaEntity> regrasEntrega = RegrasEntregaGenerate.valueOf(Cache.valores.get(Util.rota.apply("zipCode"))).pojo();
            assumingThat(regrasEntrega.get(0).getRegra_valor_isenta() == null, () -> {
                assertAll(
                        () -> assertTrue(regrasEntrega.get(0).getFilial_valor_isenta() != regrasEntrega.get(0).getRegra_valor_isenta())
                );
            });
            System.out.println("Não possui regra de entrega");
        });
    }

    @Entao("valido ShippingService - v1 - regra taxa de entrega")
    public void valido_shipping_service_v1_regra_taxa_de_entrega() {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            List<RegrasEntregaEntity> regrasEntrega = RegrasEntregaGenerate.valueOf(Cache.valores.get(Util.rota.apply("zipCode"))).pojo();
            assumingThat(regrasEntrega.get(0).getRegra_valor_isenta() == null, () -> {
                assertAll(
                        () -> assertTrue(regrasEntrega.get(0).getFilial_valor_isenta() != regrasEntrega.get(0).getRegra_valor_isenta())
                );
            });
            System.out.println("Não possui regra de entrega");
        });
    }

    private void validaTypeEntrega(String string, boolean deveRetornar) {
        assumingThat(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getStatusCode() == 200, () -> {
            List<PostDeliveriesResponse_v1_Deliveries> deliveries = Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostDeliveriesResponse_v1[].class)[0].getDeliveries();
            List<String> formaEntrega = Arrays.asList(string.split(",").clone());
            formaEntrega.stream().forEach(tipo -> {
                String entrega[] = tipo.split("-");
                Optional<PostDeliveriesResponse_v1_Deliveries> teste = deliveries.stream().filter(
                        filtro -> filtro.getDescription().getMethod().equals(entrega[0]) && filtro.getDescription().getType().equals(entrega[1])
                ).findFirst();
                assumingThat(deveRetornar, () -> {
                    assertAll(
                            () -> assertFalse(teste.isEmpty(), "Nao pode ser vazio")
                            , () -> assertEquals(teste.get().getDescription().getMethod(), entrega[0], "metodo incorreto")
                            , () -> assertEquals(teste.get().getDescription().getType(), entrega[1], "Tipo incorreto")
                    );
                });
                assumingThat(!deveRetornar, () -> {
                    assertAll(
                            () -> assertEquals(!teste.isEmpty(), deveRetornar)
                    );
                });
            });
            assertAll(
                    () -> assertEquals(Cache.chamadas.get(Util.rota.apply(ROTA)).getServiceResponse().getObjectBody(PostDeliveriesResponse_v1[].class).length, 1)
            );
        });
    }
}
