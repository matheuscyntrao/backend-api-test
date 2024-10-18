package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class CustomerCardResponse_v1 {
    private String authorizerName;
    private String cardCode;
    private String cardNumber;
    private String internalCardCode;
    private Boolean principalCard;
}
