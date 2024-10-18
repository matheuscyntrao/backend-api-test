package model.digital.pedidosEcommerce.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidoRequest_v1_Item_AutorizacaoPbm {
    private BigInteger codigoAdminConvenio;
    private String tipoPrograma;
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private String cartaoBeneficiario;
    private String cpfBeneficiario;
    private String cpfAtendimento;
    private Double percentualDesconto;
    private BigDecimal valorDesconto;
    private BigDecimal valorConvenio;
    private String numeroSessao;
    private BigInteger fatorConversaoAutorizado;
}
