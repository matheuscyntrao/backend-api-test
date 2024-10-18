package model.domino.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostOrderEcommerceOrdersRequest_v1_PaymentMethods {
    private Long agencyCode;
    private String agencyDigit;
    private Long associateCode;
    private String associateRegistration;
    private String authorizationNumber;
    private Long authorizerId;
    private Long bankAccountDigit;
    private Long bankAccountNumber;
    private Long bankSlipCustomerCode1;
    private Long bankSlipCustomerCode2;
    private String bankSlipNumber;
    private String cardAuthorizationNumber;
    private String cardHash;
    private Long cardId;
    private String cardNumber;
    private String cgc;
    private BigDecimal changeValue;
    private Long checkNumber;
    private Long checkSequence;
    private String cmc7Number;
    private String compensationDate;
    private Long covenantCardNumber;
    private Long covenantConditionSequence;
    private List<PostOrderEcommerceOrdersRequest_v1_PaymentMethods_CovenantDocuments> covenantDocuments;
    private Long covenantPaymentConditionCode;
    private Long covenantSubsidiaryCode;
    private Long creditByReturnSequence;
    private Long customerCode;
    private String cvv;
    private String dependentName;
    private String document;
    private String expirationDate;
    private Long financialInstitutionCode;
    private String firstHolder;
    private Long headOfficeSubsidiaryCode;
    private Long installmentType;
    private Long installments;
    private Boolean manuallyInserted;
    private String nitEsitef;
    private Long paymentConditionCode;
    private Long paymentConditionSequence;
    private String paymentMethodDescription;
    private Long paymentMethodSequence;
    private String paymentType;
    private Long subsidiary;
    private String transactionUSN;
    private BigDecimal value;
}
