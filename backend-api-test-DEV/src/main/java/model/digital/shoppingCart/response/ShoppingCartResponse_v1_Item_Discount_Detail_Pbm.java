package model.digital.shoppingCart.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartResponse_v1_Item_Discount_Detail_Pbm {
    private String tipoPrograma;
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private Long codigoAdminConvenio;
    private Long idConvenioPbm;
    private String cartaoBeneficiario;
    private String cpfBeneficiario;
    private String cpfAtendimento;
    private Double percentualDesconto;
    private BigDecimal precoAquisicaoUnitario;
    private BigDecimal valorDesconto;
    private BigDecimal valorConvenio;
    private Integer tipoItemVenda;
}
