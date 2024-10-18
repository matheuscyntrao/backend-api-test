package model.tioPatinhas.bankAccount.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentDetailsV1Response {
    private String barcode;
    private BigDecimal consolidatedAmount;
    private BigDecimal discount;
    private String documentType;
    private String dueDate;
    private BigDecimal fine;
    private BigDecimal interest;
    private BigDecimal maximumAmount;
    private BigDecimal minimumAmount;
    private BigDecimal totalAmount;
    private String typeableLine;
}
