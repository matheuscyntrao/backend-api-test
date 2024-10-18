package model.brocacao.omniDashboardBff.Coverage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.brocacao.omniDashboardBff.ColumnTypeDetail;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoverageSpecifc_v1Response {
    private String coverageType;
    private ColumnTypeDetail coverageColumnTypeDetail;
    private List<String> coverageValues;
}
