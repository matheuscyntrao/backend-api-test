package model.domino.pucservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutWalletItemsRequest_v1_Item {
    private Long code;
    private String description;
    private String ean;
    private BigDecimal grossPrice;
    private BigDecimal netPrice;
    private String identifier;
    private String programCode;
    private PutWalletItemsRequest_v1_Item_Treatment treatment;
}
