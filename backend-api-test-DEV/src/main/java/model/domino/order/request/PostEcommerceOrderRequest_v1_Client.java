package model.domino.order.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEcommerceOrderRequest_v1_Client {
    private String branch;
    private Long code;
    private String areaCode;
    private String trackingAreaCode;
    private String document;
    private PostEcommerceOrderRequest_v1_Client_FidelityData fidelityData;
    private String name;
    private Long phoneNumber;
    private String trackingPhone;
}
