package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locker {
    private Address address;
    private String deactivationDate;
    private String finalDate;
    private Long latitude;
    private String lockerFriendlyName;
    private Long lockerId;
    private Long lockerModelId;
    private String lockerName;
    private Long lockerNumber;
    private LockerReserve lockerReserve;
    private Long longitude;
    private Long operationIndicator;
    private String startDate;
    private Long supplySubsidiary;
}
