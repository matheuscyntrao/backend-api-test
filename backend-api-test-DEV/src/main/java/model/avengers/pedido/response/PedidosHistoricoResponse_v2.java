package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class PedidosHistoricoResponse_v2 {
    private BigInteger numeroPedido;
    private Integer filial;
    private String origemPedido;
    private BigInteger entidadeComercial;
    private Integer codigoSituacao;
    private String descricaoSituacao;
    private String dataEfetivaPedido;
    private BigDecimal valorTotal;
    private String tipo;
    private String tipoEntrega;
    private String canal;
    private PedidosHistoricoResponse_v2_DadosEntrega dadosEntrega;
}
