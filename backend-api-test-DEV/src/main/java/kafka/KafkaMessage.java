package kafka;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaMessage {
    private String key;
    private Object value;
}
