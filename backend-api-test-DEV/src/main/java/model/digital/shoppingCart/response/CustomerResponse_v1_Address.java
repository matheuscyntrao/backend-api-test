package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigInteger;

@Data
public class CustomerResponse_v1_Address {
    private BigInteger addressCode;
    private BigInteger addressNumber;
    private String city;
    private BigInteger cityCode;
    private String neighborhood;
    private String state;
    private String street;
    private BigInteger streetCode;
    private String streetType;
    private String zipCode;
}
