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
public class PostOrderRequest_v1_Delivery {
    private Boolean coveredByCovenant;
    private String id;
    private Integer subsidiary;
    private String deliveryMethod;
    private String deliveryType;
    private String deliveryDate;
    private Long feeCode;
    private BigDecimal feeValue;
    private PostOrderRequest_v1_Delivery_Address address;
    private Boolean chargeFee;
    private Integer lockerId;
    private Integer lockerDoorNumber;
    private Long lockerReserveNumber;
    private String lockerReservePassword;
}
