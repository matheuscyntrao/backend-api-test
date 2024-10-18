package model.crossover.notificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostOrderRequest_v1_Client {
    private Long code;
    private String areaCode;
    private String phoneNumber;
    private String name;
    private String document;
    private String trackingDdd;
    private String trackingPhone;
}
