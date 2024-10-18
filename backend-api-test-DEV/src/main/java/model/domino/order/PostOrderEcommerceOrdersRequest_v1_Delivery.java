package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Delivery {
    private PostOrderEcommerceOrdersRequest_v1_Delivery_Address address;
    private Boolean coveredByCovenant;
    private String deliveryDate;
    private String deliveryMethod;
    private String deliveryType;
    private Long feeCode;
    private Long feeLiberatorCode;
    private BigDecimal feeValue;
    private Long id;
    private Long lockerDoorNumber;
    private Long lockerId;
    private String lockerReserveNumber;
    private String lockerReservePassword;
    private String pickupDocument;
    private Long routeCode;
    private String routeDepartureTime;
    private String stockOrigin;
    private Long subsidiary;
}
