package model.brocacao.omniDashboardBff.Items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemAttributes {
    private String attributeName;
    private String attributeValue;
}
