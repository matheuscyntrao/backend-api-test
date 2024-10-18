package model.domino.order.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PostEcommerceOrderRequest_v1_Cassi {
    private String eventPassword;
    private Long idItemScheduling;
    private Long itemRequestNumber;
    private Long requestCode;
    private Long supplierBarcode;
    private Long tgaCode;
}
