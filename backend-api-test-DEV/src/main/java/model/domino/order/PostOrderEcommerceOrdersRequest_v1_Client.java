package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Client {
    private String branch;
    private Long code;
    private String ddd;
    private String document;
    private PostOrderEcommerceOrdersRequest_v1_Client_Fidelity fidelityData;
    private String name;
    private String phoneNumber;
    private String trackingDdd;
    private String trackingPhone;
}
