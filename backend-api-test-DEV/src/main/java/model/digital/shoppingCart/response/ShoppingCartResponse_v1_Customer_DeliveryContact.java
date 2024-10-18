package model.digital.shoppingCart.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Customer_DeliveryContact {
    private Long contactCode;
    private Long communicationCode;
    private Integer ddi;
    private Integer ddd;
    private String contactNumber;
    private String telephoneExtension;
    private String email;
    private String observation;
    private Long communicationCodeType;
    private String preferential;
    private String contactName;
    private String exclusionDate;
    private String lastUpdateTime;
}
