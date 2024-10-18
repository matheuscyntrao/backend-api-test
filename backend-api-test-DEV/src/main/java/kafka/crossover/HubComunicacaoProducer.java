package kafka.crossover;

import kafka.KafkaMessage;
import kafka.Producer;
import utils.Util;
import utils.service.Cache;

import java.util.function.Consumer;

public interface HubComunicacaoProducer {

    String PUBLISHER_NOTIFICACAO = "Notificacao-Hub-Pedido";

    Consumer<String> pedidoAnalisadoPublisher = (cenario) -> {
        String topico = "PEDIDOS";
        Object messagem = Cache.chamadas.get(Util.rota.apply(PUBLISHER_NOTIFICACAO)).getServiceSpecs().getObjectBody(Object.class);
        KafkaMessage message = KafkaMessage.builder().key(cenario).value(messagem).build();
        Producer.simpleProduce.accept(message, topico);
    };


}
