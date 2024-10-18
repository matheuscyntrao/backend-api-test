package kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.function.BiConsumer;


public interface Producer {
    String BOOTSTRAP_SERVERS_CONFIG = "tureistst201.dimed.com.br:9092, tureistst202.dimed.com.br:9092, tureistst203.dimed.com.br:9092";

    BiConsumer<KafkaMessage, String> simpleProduce = (kafkaMessage, topic) -> {
        ObjectMapper mapper = new ObjectMapper();
        String value = null;
        String key = null;
        try {
            value = mapper.writeValueAsString(kafkaMessage.getValue());
            key = kafkaMessage.getKey();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS_CONFIG);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        ProducerRecord<String, String> data;
        data = new ProducerRecord<String, String>(topic, key, value);
        producer.send(data);
        producer.close();
    };

    static void main(String[] args) {
        Object messagem = new Object();  //Pojo normal
        KafkaMessage message = KafkaMessage.builder().key("ZmudaRN001").value(messagem).build();
        String topic = "pedido-analisado";
        Producer.simpleProduce.accept(message, topic);
    }
}
