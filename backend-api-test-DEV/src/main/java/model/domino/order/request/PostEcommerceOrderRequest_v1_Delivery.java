package model.domino.order.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostEcommerceOrderRequest_v1_Delivery {
    private PostEcommerceOrderRequest_v1_BillingAddress address;
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
