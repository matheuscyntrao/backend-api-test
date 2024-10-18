package model.digital.panvelEcommerceBff.locker.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff.cashPayment.response.orm.Address;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Locker {
    private Address address;
    private List<Long> coordinates;
    private String deactivationDate;
    private String finalDate;
    private String lockerFriendlyName;
    private Long lockerId;
    private Long lockerModelId;
    private String lockerName;
    private Long lockerNumber;
    private Long operationIndicator;
    private Long shipmentType;
    private String startDate;
    private Long supplySubsidiary;
}
