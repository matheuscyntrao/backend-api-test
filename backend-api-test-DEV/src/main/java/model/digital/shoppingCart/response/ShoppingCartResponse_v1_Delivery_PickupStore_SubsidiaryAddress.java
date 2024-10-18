package model.digital.shoppingCart.response;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ShoppingCartResponse_v1_Delivery_PickupStore_SubsidiaryAddress {
    private Long localityCode;
    private Long streetCode;
    private Double latitude;
    private Double longitude;
    private String streetType;
    private String street;
    private Long number;
    private String complement;
    private String zipCode;
    private String city;
    private String neighborhood;
    private String state;
}
