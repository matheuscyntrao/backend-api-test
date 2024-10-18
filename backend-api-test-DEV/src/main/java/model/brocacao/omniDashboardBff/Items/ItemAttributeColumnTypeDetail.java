package model.brocacao.omniDashboardBff.Items;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.brocacao.omniDashboardBff.PossibleOperator;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemAttributeColumnTypeDetail {
    private String columnType;
    private List<PossibleOperator> possibleOperators;
}
