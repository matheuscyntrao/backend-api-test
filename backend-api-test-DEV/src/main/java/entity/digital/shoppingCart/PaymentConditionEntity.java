package entity.digital.shoppingCart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.time.Instant;

@Entity("Payment conditions")
@Data
public class PaymentConditionEntity {
    @Id
    private ObjectId id;
    private PaymentConditionEntityCondition conditions[];
}

@Data
class PaymentConditionEntityCondition {
    private Integer paymentConditionCode;
    private String paymentConditionDescription;
    private Instant paymentConditionInitialDate;
    private String covenantDescription;
    private Integer conditionSequence;
    private Integer paymentCode;
    private Boolean asksTypingDate;
    private Integer subsidiaryCode;
    private Integer covenantType;
    private Integer covenantSubsidiaryCode;
    private Integer installmentsNumber;
    private Long covenantCode;

}