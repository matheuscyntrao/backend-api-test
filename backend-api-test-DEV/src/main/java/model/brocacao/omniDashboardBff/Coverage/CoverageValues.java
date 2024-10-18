package model.brocacao.omniDashboardBff.Coverage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoverageValues {
    private String codigoLocalidade;
    private String nomeBairro;
}
