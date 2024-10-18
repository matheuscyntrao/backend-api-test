package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.math.BigInteger;

@Data
public class ShippingPickupResponse_v1_Store {
    private String friendlyName;
    private String closes;
    private String nextOpeningTime;
    private String cnpj;
    private String opens;
    private String phone;
    private Boolean isOpen;
    private Boolean storeDayWorks;
    @Valid
    private ShippingPickupResponse_v1_Store_Address subsidiaryAddress;
    private BigInteger subsidiaryCode;
    private ShippingPickupResponse_v1_Store_StockDeviation stockDeviation;
}
