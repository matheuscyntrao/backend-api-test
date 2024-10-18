package stepdef.plataforma.paymentGateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import kafka.plataforma.PaymentGatewayProducer;
import model.plataforma.request.ProducerPedidoAnalisado;
import model.plataforma.request.ProducerPedidoAnalisado_ClearSale;
import model.plataforma.request.ProducerPedidoAnalisado_Konduto;
import service.domino.order.OrderV1;
import stepdef.avengers.pedido.GetPedidoV2Steps;
import utils.CucumberUtils;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class ProducerPedidoAnalisadoSteps {
    @Dado("possuo dados para Plataforma - Producer - PedidoAnalisado:")
    public void possuo_dados_para_plataforma_producer_pedido_analisado(DataTable dataTable) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(PaymentGatewayProducer.PUBLISHER_PEDIDOANALISADO), CucumberUtils.getObjectBody(dataTable, ProducerPedidoAnalisado.class));
    }

    @Dado("possuo dados para Plataforma - Producer - PedidoAnalisado kondutoNotification:")
    public void possuo_dados_para_plataforma_producer_pedido_analisado_konduto_notification(DataTable dataTable) throws JsonProcessingException {
        ProducerPedidoAnalisado input = Cache.chamadas.get(Util.rota.apply(PaymentGatewayProducer.PUBLISHER_PEDIDOANALISADO)).getServiceSpecs().getObjectBody(ProducerPedidoAnalisado.class);
        input.setKondutoNotification(CucumberUtils.getObjectBody(dataTable, ProducerPedidoAnalisado_Konduto.class));
        Cache.chamadas.get(Util.rota.apply(PaymentGatewayProducer.PUBLISHER_PEDIDOANALISADO)).getServiceSpecs().setBody(input);
    }

    @Quando("executo Plataforma - Producer - PedidoAnalisado {string}")
    public void executo_plataforma_producer_pedido_analisado(String string) {
        PaymentGatewayProducer.pedidoAnalisadoPublisher.accept(string);
    }

    @Entao("valido Plataforma - Producer - PedidoAnalisado")
    public void valido_plataforma_producer_pedido_analisado() {

    }

    @Entao("publico Plataforma - Producer - PedidoAnalisado retornando {string}")
    public void publico_plataforma_producer_pedido_analisado_retornando(String status) throws Throwable {
        assumingThat(!status.isBlank(), () -> {
            Long pedido = Cache.chamadas.get(Util.rota.apply(OrderV1.POST_ECOMMERCE_ORDERS)).getServiceResponse().getObjectBody(Long[].class).clone()[0];
            Long carrinho = new GetPedidoV2Steps().getCarrinho(pedido);
            BuilderRequest.body.accept(Util.rota.apply(PaymentGatewayProducer.PUBLISHER_PEDIDOANALISADO), ProducerPedidoAnalisado.builder().antifraudType("CLEARSALE").clearSaleNotification(
                    ProducerPedidoAnalisado_ClearSale.builder().score(99.94).code(carrinho.toString()).status(status).build()
            ).build());
            PaymentGatewayProducer.pedidoAnalisadoPublisher.accept(carrinho.toString());
        });
    }
}
