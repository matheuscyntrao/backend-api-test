package model.brocacao.omniDashboardBff.Items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item_v1Response {
    private ItemAttributeColumnTypeDetail itemAttributeColumnTypeDetail;
    private ItemAttributes[] itemAttributes;
}
