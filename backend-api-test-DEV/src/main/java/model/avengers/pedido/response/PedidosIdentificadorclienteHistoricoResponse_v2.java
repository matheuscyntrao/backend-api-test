package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosIdentificadorclienteHistoricoResponse_v2 {
    private BigInteger numeroPedido;
    private BigInteger filial;
    private String origemPedido;
    private BigInteger entidadeComercial;
    private Integer codigoSituacao;
    private String descricaoSituacao;
    private String dataEfetivaPedido;
    private BigDecimal valorTotal;
    private String tipo;
    private String tipoEntrega;
    private String canal;
    private PedidosIdentificadorclienteHistoricoResponse_v2_TipoEntrega dadosEntrega;
}
