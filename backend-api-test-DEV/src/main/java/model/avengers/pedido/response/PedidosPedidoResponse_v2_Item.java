package model.avengers.pedido.response;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Data
public class PedidosPedidoResponse_v2_Item {
    private BigInteger codigoItem;
    private Integer numeroItem;
    private Integer quantidade;
    private Integer quantidadeEntregar;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private Double percentualIsencao;
    private String preVenda;
    private BigInteger codigoItemAgendamento;
    private BigInteger codigoIav;
    private BigInteger quantidadeEmEstoque;
    private PedidosPedidoResponse_v2_Item_Desconto desconto;
    private PedidosPedidoResponse_v2_Item_Liberador liberador;
    private PedidosPedidoResponse_v2_Item_Promocao promocao;
    private String contempladoConvenio;
    private PedidosPedidoResponse_v2_RequisicaoCassi requisicaoCassi;
    private PedidosPedidoResponse_v2_Item_PlanoBeneficioMedico planoBeneficioMedico;
    private List<PedidosPedidoResponse_v2_Item_AutorizacoesPbm> autorizacoesPbms;
    private PedidosPedidoResponse_v2_Item_Pack pack;
    private PedidosPedidoResponse_v2_Item_Receita receita;
    private Boolean itemDigitado;
    private BigInteger codigoQuadroOferta;
    private PedidosPedidoResponse_v2_Item_PedidoCd pedidoCD;
}
