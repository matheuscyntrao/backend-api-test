package model.digital.panvelEcommerceBff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.digital.panvelEcommerceBff._orm.Discount;
import model.digital.panvelEcommerceBff._orm.Images;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetItemsTagsV1Response {
    private String name;
    private Long store;
    private Long panvelCode;
    private String zipCode;
    private String description;
    private Double originalPrice;
    private Discount discount;
    private String installments;
    private List<Images> images;
    private List<String> tags;
}
