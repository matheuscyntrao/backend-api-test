package model.digital.shoppingCart.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ShippingLockerResponse_v1_Locker_Address {
    private Integer localeCode;
    private Integer streetCode;
    private String streetType;
    private String streetName;
    private Integer addressNumber;
    private String complement;
    private String neighborhood;
    private String zipCode;
    private String localeName;
    private String state;
    private String country;
}
