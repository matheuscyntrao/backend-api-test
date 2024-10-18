package model.digital.shoppingCart.response;

import lombok.Data;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Data
public class ShoppingCartResponse_v1_Delivery_Locker {
    private Long lockerId;
    private Long lockerModelId;
    private Long lockerNumber;
    private String lockerName;
    private String lockerFriendlyName;
    private String startDate;
    private String finalDate;
    private String deactivationDate;
    private Long operationIndicator;
    private Double latitude;
    private Double longitude;
    private Long supplySubsidiary;
    @Valid
    private ShoppingCartResponse_v1_Delivery_Locker_Adrress address;
    @Valid
    private ShoppingCartResponse_v1_Delivery_Locker_LockerReserve lockerReserve;

}
