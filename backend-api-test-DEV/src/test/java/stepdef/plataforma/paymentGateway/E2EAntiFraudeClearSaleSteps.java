package stepdef.plataforma.paymentGateway;

import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import service.domino.order.OrderV1;
import service.qa.Topicos;
import stepdef.avengers.pedido.GetPedidoV2Steps;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class E2EAntiFraudeClearSaleSteps {

    @Entao("valido Qa - Pedido - Topico publicou {string}")
    public void valido_qa_pedido_topico_publicou(String topicosPublicados) {
        assumingThat(!topicosPublicados.isBlank(), () -> {
            Long pedido = Cache.chamadas.get(Util.rota.apply(OrderV1.POST_ECOMMERCE_ORDERS)).getServiceResponse().getObjectBody(Long[].class).clone()[0];
            Long carrinho = new GetPedidoV2Steps().getCarrinho(pedido);
            String topicos[] = topicosPublicados.split(",");
            Arrays.stream(topicos).forEach(topico -> {
                try {
                    Assert.assertTrue(findPedidoTopico(carrinho.toString(), topico, true, 0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    @Entao("valido Qa - Pedido - Topico nao publicou {string}")
    public void valido_qa_pedido_topico_nao_publicou(String topicosNaoPublicados) {
        assumingThat(!topicosNaoPublicados.isBlank(), () -> {
            Long pedido = Cache.chamadas.get(Util.rota.apply(OrderV1.POST_ECOMMERCE_ORDERS)).getServiceResponse().getObjectBody(Long[].class).clone()[0];
            Long carrinho = new GetPedidoV2Steps().getCarrinho(pedido);
            String topicos[] = topicosNaoPublicados.split(",");
            Arrays.stream(topicos).forEach(topico -> {
                try {
                    Assert.assertFalse(String.format("Carrinho %s nao encontrado no topico %s", carrinho.toString(), topico), findPedidoTopico(carrinho.toString(), topico, false, 0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }


    public Boolean findPedidoTopico(String carrinho, String topico, Boolean expected, Integer retry) throws InterruptedException {
        BuilderRequest.path.accept(Util.rota.apply(Topicos.GET_PEDIDO_TOPICO), Map.of("pedido", carrinho.toString(), "topico", topico));
        Thread.sleep(600);
        Topicos.getPedidoTopico.run();
        Boolean result = Cache.chamadas.get(Util.rota.apply(Topicos.GET_PEDIDO_TOPICO)).getServiceResponse().getStatusCode().equals(200);
        return result.equals(expected) || retry.equals(10) ? result : findPedidoTopico(carrinho, topico, expected, retry + 1);
    }
}
