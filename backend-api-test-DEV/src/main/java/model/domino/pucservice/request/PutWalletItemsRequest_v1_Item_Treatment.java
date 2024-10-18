package model.domino.pucservice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PutWalletItemsRequest_v1_Item_Treatment {
    private Integer amount;
    private Integer frequency;
    private String compositionUnit;
    private String endDate;
    private String frequencyUnit;
    private String startDate;
}
