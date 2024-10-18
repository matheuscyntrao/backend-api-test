package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.time.LocalTime;

@Data
public class ShoppingCartResponse_v1_Delivery_PickupStore {
    private Long subsidiaryCode;
    private String friendlyName;
    private String cnpj;
    private String opens;
    private String pickupPersonCpf;
    private String closes;
    private String nextOpeningTime;
    private String phone;
    private Boolean isOpen;
    private Boolean storeDayWorks;
    @Valid
    private ShoppingCartResponse_v1_Delivery_PickupStore_SubsidiaryAddress subsidiaryAddress;
    private ShoppingCartResponse_v1_Delivery_PickupStore_StockDeviation stockDeviation;
}
