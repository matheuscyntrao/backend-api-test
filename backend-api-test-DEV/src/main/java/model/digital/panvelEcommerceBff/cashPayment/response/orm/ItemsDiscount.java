package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.Subscription;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDiscount {
    private String identifier;
    private String image;
    private String link;
    private Long originalPrice;
    private Long panvelCode;
    private Prescription prescription;
    private String productName;
    private Integer quantity;
    private Subscription subscription;
    private List<String> tags;
    private Long total;
}
