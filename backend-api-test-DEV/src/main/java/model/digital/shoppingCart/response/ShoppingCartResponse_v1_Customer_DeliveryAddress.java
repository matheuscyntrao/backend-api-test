package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShoppingCartResponse_v1_Customer_DeliveryAddress {
    private Long streetCode;
    private Long addressCode;
    private String zipCode;
    private String street;
    private String streetType;
    private Long addressNumber;
    private String neighborhood;
    private Long cityCode;
    private String city;
    private String state;
    private String identifier;
}
