package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosOrderidResponse_v1_Item_AutorizacaoPbm {
    private String tipoPrograma;
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private BigInteger codigoAdminConvenio;
    private BigInteger idConvenioPbm;
    private String cartaoBeneficiario;
    private String cpfBeneficiario;
    private String cpfAtendimento;
    private Double percentualDesconto;
    private BigDecimal precoAquisicaoUnitario;
    private BigDecimal valorDesconto;
    private BigDecimal valorConvenio;
    private Integer tipoItemVenda;
}
