package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LockerReserve {
    private String deliveryDate;
    private String lockerName;
    private String lockerPort;
    private String reserve;
    private String reservePassword;
    private Long shippingType;
    private Long shippingTypeCode;
}
