package model.digital.panvelEcommerceBff.itemDetail;


import lombok.Data;
import model.digital.panvelEcommerceBff.itemDetail.orm.Pack;
import model.digital.panvelEcommerceBff._orm.Discount;
import model.digital.panvelEcommerceBff._orm.Images;
import model.digital.panvelEcommerceBff.cashPayment.response.orm.Pbm;


import java.math.BigDecimal;
import java.util.List;

@Data
public class GetItemV1Response {
    private String alert;
    private String bula;
    private String description;
    private Discount discount;
    private List<Images> images;
    private String installments;
    private String name;
    private BigDecimal originalPrice;
    private Pack pack;
    private Long panvelCode;
    private Pbm pbm;
    private Long store;
    private List<String> tags;
    private Integer zipcode;
}
