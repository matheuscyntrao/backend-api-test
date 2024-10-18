package model.digital.pedidosEcommerce.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class GetPedidosIdentificadorclienteHistoricoResponse_v1_Historico {
    private BigInteger numeroPedido;
    private BigInteger filial;
    private String origemPedido;
    private BigInteger entidadeComercial;
    private Integer codigoSituacao;
    private String descricaoSituacao;
    private String descricaoSituacaoAmigavel;
    private String dataEfetivaPedido;
    private BigDecimal valorTotal;
    private String tipo;
    private String tipoEntrega;
    private String canal;
    private GetPedidosIdentificadorclienteHistoricoResponse_v1_Historico_DescricaoEntrega dadosEntrega;
}
