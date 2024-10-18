package model.timeB.phw31tst.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostVendaResponseV1Itens {
    private Integer codigo;
    private String descricao;
    private Double valorUnitario;
    private Integer quantidade;
    private String unidadeMedida;
    private Double percentualDesconto;
    private Double valorDesconto;
    private Double valorTotal;
}