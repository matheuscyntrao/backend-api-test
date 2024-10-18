package stepdef.crossover.notificacao;

import com.fasterxml.jackson.core.JsonProcessingException;
import dataProvider.crossover.OrderNotificacaoGenerate;
import io.cucumber.java.pt.Dado;
import kafka.crossover.HubComunicacaoProducer;
import utils.Util;
import utils.service.BuilderRequest;

import java.util.Map;

public class NotificacaoEmailSteps {
    @Dado("que possuo dados para Notificacao - Hub - Email:")
    public void que_possuo_dados_para_notificacao_hub_email(Map<String, String> dados) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(HubComunicacaoProducer.PUBLISHER_NOTIFICACAO), OrderNotificacaoGenerate.ORDER_SIMPLES.pojo(
                dados.get("TIPO_PEDIDO")
                , dados.get("CODIGO_SITUACAO_PEDIDO")
                , dados.get("FORMA_DE_ENTREGA")
                , Long.parseLong(dados.get("PEDIDO"))
        ));
    }

    @Dado("que possuo dados para Notificacao - Hub - Email {string}:")
    public void que_possuo_dados_para_notificacao_hub_email(String exemplo) throws JsonProcessingException {
        BuilderRequest.body.accept(Util.rota.apply(HubComunicacaoProducer.PUBLISHER_NOTIFICACAO), OrderNotificacaoGenerate.valueOf(exemplo).pojo(null, null, null, null));
    }

    @Dado("efetuo Notificacao - Hub - Email {string}")
    public void efetuo_notificacao_hub_email(String fluxo) {
        HubComunicacaoProducer.pedidoAnalisadoPublisher.accept(fluxo);
    }
}
