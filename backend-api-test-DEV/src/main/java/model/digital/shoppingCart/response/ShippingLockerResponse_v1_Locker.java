package model.digital.shoppingCart.response;

import lombok.Data;

@Data
public class ShippingLockerResponse_v1_Locker {
    private Integer lockerId;
    private Integer lockerModelId;
    private Integer lockerNumber;
    private String lockerName;
    private String lockerFriendlyName;
    private String startDate;
    private String finalDate;
    private Integer operationIndicator;
    private Double coordinates[];
    private Integer supplySubsidiary;
    private ShippingLockerResponse_v1_Locker_Address address;
}
