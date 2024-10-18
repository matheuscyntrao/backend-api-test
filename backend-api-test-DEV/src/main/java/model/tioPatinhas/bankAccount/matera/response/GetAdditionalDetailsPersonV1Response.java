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
public class GetAdditionalDetailsPersonV1Response {
    private String father;
    private String mother;
    private String birthCity;
    private String birthState;
    private String birthCountry;
    private String partner;
    private Integer occupation;
    private String documentType;
    private GetMateraRGV1Response rg;
    private GetMateraOtherDocumentV1Response otherDocument;
    private String maritalStatus;
    private String gender;
    //($date(yyyy-mm-dd))
    private String birthDate;
    private BigDecimal businessLine;
    private BigDecimal financialStatistic;
    private GetMateraClientV1Response legalResponsible;
    private BigDecimal monthlyIncome;
}
