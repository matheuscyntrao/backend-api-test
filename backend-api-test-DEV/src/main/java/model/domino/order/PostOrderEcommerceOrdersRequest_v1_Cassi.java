package model.domino.order;

import lombok.Data;

@Data
public class PostOrderEcommerceOrdersRequest_v1_Cassi {
    private String eventPassword;
    private Long idItemScheduling;
    private Long itemRequestNumber;
    private Long requestCode;
    private Long supplierBarcode;
    private Long tgaCode;
}
