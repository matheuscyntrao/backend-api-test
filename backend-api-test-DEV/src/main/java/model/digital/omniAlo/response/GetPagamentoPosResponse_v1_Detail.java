package model.digital.omniAlo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPagamentoPosResponse_v1_Detail {
    private Long codigoFilialConvenio;
    private Long codigoConvenio;
    private String descricaoConvenio;
    private Boolean possuiCondicaoPagamento;
    private Long codigoFormaPagamento;
}
