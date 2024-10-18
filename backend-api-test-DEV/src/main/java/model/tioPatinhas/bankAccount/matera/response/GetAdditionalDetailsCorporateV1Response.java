package model.tioPatinhas.bankAccount.matera.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAdditionalDetailsCorporateV1Response {
    private String companyName;
    private BigDecimal businessLine;
    private String establishmentForm;
    //($date(yyyy-mm-dd))
    private String establishmentDate;
    private GetMateraClientV1Response representatives[];
    private String stateRegistration;
    private BigDecimal monthlyIncome;
    private BigDecimal financialStatistic;
}
