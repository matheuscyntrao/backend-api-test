package model.digital.panvelEcommerceBff.cashPayment.response.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pbm {
    private String cartaoBeneficiario;
    private Long codigoAdminConvenio;
    private String cpfAtendimento;
    private String cpfBeneficiario;
    private Long idConvenioPbm;
    private String identificadorTransacao;
    private String nsuAutorizacao;
    private BigDecimal percentualDesconto;
    private BigDecimal precoAquisicaoUnitario;
    private Long tipoItemVenda;
    private String tipoPrograma;
    private BigDecimal valorConvenio;
    private BigDecimal valorDesconto;
}
