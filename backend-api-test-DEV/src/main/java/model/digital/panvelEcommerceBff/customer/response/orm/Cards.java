package model.digital.panvelEcommerceBff.customer.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cards {
    private String authorizerName;
    private String cardCode;
    private String cardNumber;
    private Boolean principalCard;
}
