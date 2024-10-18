package model.timeB.skyhub.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetOrderQueueResponseStatus {
    private String type;
    private String label;
    private String code;
}