package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Delivery_Locker_Adrress {
    private Long localeCode;
    private Long streetCode;
    private String streetType;
    private String streetName;
    private Long addressNumber;
    private String complement;
    private String neighborhood;
    private String zipCode;
    private String localeName;
    private String state;
    private String country;
}
