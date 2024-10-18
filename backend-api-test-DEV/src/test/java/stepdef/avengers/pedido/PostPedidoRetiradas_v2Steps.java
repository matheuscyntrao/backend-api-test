package stepdef.avengers.pedido;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.avengers.pedido.request.PostPedidosRetirada_v2;
import org.testng.Assert;
import service.avengers.pedido.Pedidov2;
import utils.ResponseValidator;
import utils.Util;
import utils.service.BuilderRequest;
import utils.service.Cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public class PostPedidoRetiradas_v2Steps {

    List<Long> numerosPedidos = new ArrayList<>();

    @Dado("possuo dados para Pedido - v2 - PostPedidoRetiradas:")
    public void possuoDadosParaPedidoV2PostPedidoRetiradas(Map<String, String> arg1) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(Pedidov2.POST_PEDIDOS_RETIRADAS), arg1);
        //TODO: percorrer o array de numeros de pedidos e adicionar na lista pra varrer depois na validação de trocas de status
    }

    @Quando("executo Pedido - v2 - PostPedidoRetiradas")
    public void executoPedidoV2PostPedidoRetiradas() {
        Pedidov2.postPedidosRetiradas.run();
    }

    @Entao("sistema processa Pedido - v2 - PostPedidoRetiradas:")
    public void sistemaProcessaPedidoV2PostPedidoRetiradas(DataTable dataTable) throws Exception {
        ResponseValidator.validaResponse(dataTable
                , Cache.chamadas.get(Util.rota.apply(Pedidov2.POST_PEDIDOS_RETIRADAS)).getServiceResponse()
                , PostPedidosRetirada_v2.class
        );
    }

    @E("valido Pedido - v2 - PostPedidoRetiradas troca de Status {string}")
    public void validoPedidoV2PostPedidoRetiradasTrocaDeStatus(String mensagemPrevista) {
       int statusCode = Cache.chamadas.get(Util.rota.apply(Pedidov2.POST_PEDIDOS_RETIRADAS)).getServiceResponse().getStatusCode();
       assumingThat(statusCode == 204 , () -> {
            String response = Cache.chamadas.get(Util.rota.apply(Pedidov2.POST_PEDIDOS_RETIRADAS)).getServiceResponse().getObjectBody(String.class);
            //verifica se passou pelo status 12 e 10
           //TODO:Fazer a varredura e verificar todos os numeros de pedidos  PedidosQuerie.verifyStatusPedido(numeroPedido);
       });
       assumingThat(statusCode  == 404, () -> {
            String mensagemRetorno = Cache.chamadas.get(Util.rota.apply(Pedidov2.POST_PEDIDOS_RETIRADAS)).getServiceResponse().getBody();
            Assert.assertTrue(mensagemRetorno.contains(mensagemPrevista), "Mensagem esperada:" + mensagemPrevista);
        });
    }

}
