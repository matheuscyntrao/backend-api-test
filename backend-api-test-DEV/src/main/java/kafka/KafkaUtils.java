package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

public class KafkaUtils {
    public <T> T getObjectMessage(String message, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap bean;
        T mappedBody = null;
        KafkaMessage mappedMessage;
        try {
            KafkaMessage kafkaMessage = mapper.readValue(message, KafkaMessage.class);
            String item = mapper.writeValueAsString(kafkaMessage.getValue());
            mappedBody = mapper.readValue(item, clazz);
            return mappedBody;
        } catch (IOException e) {
            System.out.println("erro ao efetuar o parse " + e.getMessage());
        }
        return mappedBody;
    }

    public static KafkaMessage getKafkaMessage(String message) {
        ObjectMapper mapper = new ObjectMapper();
        KafkaMessage kafkaMessage = null;
        try {
            kafkaMessage = mapper.readValue(message, KafkaMessage.class);
            return kafkaMessage;
        } catch (IOException e) {
            System.out.println("erro ao efetuar o parse " + e.getMessage());
        }
        return kafkaMessage;
    }

}
