package kafka.plataforma;

import kafka.KafkaMessage;
import kafka.Producer;
import utils.Util;
import utils.service.Cache;

import java.util.function.Consumer;

public interface PaymentGatewayProducer {

    String PUBLISHER_PEDIDOANALISADO = "PaymentGateway-Producer-PedidoAnalisado";

    Consumer<String> pedidoAnalisadoPublisher = (cenario) -> {
        String topico = "PEDIDO-ANALISADO";
        Object messagem = Cache.chamadas.get(Util.rota.apply(PUBLISHER_PEDIDOANALISADO)).getServiceSpecs().getObjectBody(Object.class);
        KafkaMessage message = KafkaMessage.builder().key(cenario).value(messagem).build();
        Producer.simpleProduce.accept(message, topico);
    };


}
