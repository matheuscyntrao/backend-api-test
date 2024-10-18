package model.digital.entrega.v3.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntregasResponse {
    private Integer codigo;
    private Long filial;
    private String tipoDeEntrega;
    private Long codigoTipoDeEntrega;
    private Integer prazoEntrega;
    private String unidadePrazoEntrega;
    private String nome;
    private List<PostEntregasResponse_ItemComRestricao> itensComRestricao;
    private PostEntregasResponse_ItemTaxa itemTaxa;
    private String horarioAberturaFilial;
    private List<PostEntregasResponse_HorarioRota> horarioRota;
    private BigDecimal valorFaltantefreteGratis;
    private String origemDesvioEstoque;
    private Integer logistica;
}
