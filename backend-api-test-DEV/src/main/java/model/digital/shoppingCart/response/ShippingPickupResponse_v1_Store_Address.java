package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class ShippingPickupResponse_v1_Store_Address {
    private String city;
    private String complement;
    private Double latitude;
    private BigInteger localityCode;
    private Double longitude;
    private String neighborhood;
    private BigInteger number;
    private String state;
    private String street;
    private BigInteger streetCode;
    private String streetType;
    private String zipCode;
}
