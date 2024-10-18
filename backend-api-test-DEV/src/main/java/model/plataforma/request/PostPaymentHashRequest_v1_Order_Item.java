package model.plataforma.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PostPaymentHashRequest_v1_Order_Item {
    private String description;
    private Long itemCode;
    private String name;
    private Integer quantity;
    private BigDecimal valueDiscountUnitary;
    private BigDecimal valueUnitary;
}
