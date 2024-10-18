package model.avengers.pedido.request;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PostPedidosRequest_v2_Item_AutorizacoesPbm {
    private BigInteger codigoAdminConvenios;
    private String tipoPrograma;
    private String nsuAutorizacao;
    private String identificadorTransacao;
    private String cartaoBeneficiario;
    private String cpfBeneficiario;
    private String cpfAtendimento;
    private BigDecimal precoAquisicaoUnitario;
    private BigDecimal percentualDesconto;
    private BigDecimal valorDesconto;
    private BigDecimal valorConvenio;
    private BigDecimal fatorConversaoAutorizado;
    private String numeroSessao;
}
