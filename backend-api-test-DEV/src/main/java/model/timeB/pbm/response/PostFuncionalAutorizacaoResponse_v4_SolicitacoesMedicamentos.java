package model.timeB.pbm.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostFuncionalAutorizacaoResponse_v4_SolicitacoesMedicamentos {
    private PostFuncionalAutorizacaoResponse_v4_SolicitacoesMedicamentos_Medicamentos medicamentos;
    private Integer quantidadeAprovada;
    private BigDecimal percentualDesconto;
    private BigDecimal percentualDiferencaPreco;
    private BigDecimal percentualSubsidio;
    private BigDecimal valorPrecoBase;
    private BigDecimal precoMaximoConsumidor;
    private BigDecimal precoVenda;
    private BigDecimal precoFabricaUnitario;
    private BigDecimal precoAquisicaoUnitario;
    private BigDecimal valorRepasseVarejo;
    private BigDecimal valorTotal;
}
