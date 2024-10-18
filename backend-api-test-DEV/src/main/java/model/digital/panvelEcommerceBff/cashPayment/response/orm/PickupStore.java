package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PickupStore {
    private String closes;
    private String cnpj;
    private String friendlyName;
    private String isOpen;
    private String nextOpeningTime;
    private String opens;
    private String phone;
    private StockDeviation stockDeviation;
    private Boolean storeDayWorks;
    private Address subsidiaryAddress;
    private Long subsidiaryCode;
}
